/****************************************************************************
 * Copyright 2012 Timothy Gordon Lavers (Australia)
 *
 *                          The Wide Open License (WOL)
 *
 * Permission to use, copy, modify, distribute and sell this software and its
 * documentation for any purpose is hereby granted without fee, provided that
 * the above copyright notice and this license appear in all source copies.
 * THIS SOFTWARE IS PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF
 * ANY KIND. See http://www.dspguru.com/wol.htm for more information.
 *
 *****************************************************************************/
package org.grandtestauto.loganalysis;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.grandtestauto.Messages;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extracts information from a GrandTestAuto log file or printout.
 *
 * @author Tim Lavers
 */
public class LogFileAnalyser {
    private Map<String, Boolean> unitTestResults = new HashMap<>();
    private Map<String, Double> unitTestTimes = new HashMap<>();
    private Map<String, Boolean> functionTestResults = new HashMap<>();
    private Map<String, Double> functionTestTimes = new HashMap<>();
    private static String PASSED;
    private static String FAILED;
    private static String UNIT_TEST_PACKAGE_PATTERN;
    private static String FUNCTION_TEST_PACKAGE_START_PATTERN;
    public static final String TIME_PATTERN = "(\\d*,?\\d*(\\.\\d*)?)s";
    private static String TEST_RESULT_PATTERN = "(\\S*) (passed|failed), " + TIME_PATTERN;

    static {
        PASSED = Messages.message(Messages.SK_PASSED);
        FAILED = Messages.message(Messages.SK_FAILED);
        String resultGroup = "(" + PASSED + "|" + FAILED + ")";
        UNIT_TEST_PACKAGE_PATTERN = Messages.message(Messages.TPK_UNIT_TEST_PACK_RESULTS, "(.*)", resultGroup) + "\\D*" + TIME_PATTERN;
        FUNCTION_TEST_PACKAGE_START_PATTERN = Messages.message(Messages.SK_RUNNING_FUNCTION_OR_LOAD_TESTS_PATTERN);
    }

    public LogFileAnalyser(File logFile) throws IOException {
        Pattern utPattern = Pattern.compile(UNIT_TEST_PACKAGE_PATTERN);
        Pattern ftStartPattern = Pattern.compile(FUNCTION_TEST_PACKAGE_START_PATTERN);
        Pattern testResultPattern = Pattern.compile(TEST_RESULT_PATTERN);
        LineIterator iterator = FileUtils.lineIterator(logFile);
        String currentFTPackage = null;
        try {
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                Matcher utMatcher = utPattern.matcher(line);
                if (utMatcher.find()) {
                    String packageName = utMatcher.group(1);
                    String passedOrFailed = utMatcher.group(2);
                    unitTestResults.put(packageName, PASSED.equals(passedOrFailed));
                    String timeStr = utMatcher.group(3);
                    Double time = parseTime(timeStr);
                    if (time != null) {
                        unitTestTimes.put(packageName, time);
                    }
                    continue;
                }
                Matcher ftStartMatcher = ftStartPattern.matcher(line);
                if (ftStartMatcher.find()) {
                    currentFTPackage = ftStartMatcher.group(2);
                    continue;
                }
                Matcher testResultMatcher = testResultPattern.matcher(line);
                if (testResultMatcher.find()) {
                    String testName = currentFTPackage + "." + testResultMatcher.group(1);
                    String passedOrFailed = testResultMatcher.group(2);
                    functionTestResults.put(testName, PASSED.equals(passedOrFailed));
                    String timeStr = testResultMatcher.group(3);
                    Double time = parseTime(timeStr);
                    if (time != null) {
                        functionTestTimes.put(testName, time);
                    }
                }
            }
        } finally {
            iterator.close();
        }
    }

    @Nullable
    private Double parseTime(String timeStr) {
        DecimalFormat format = new DecimalFormat("#,###.000");
        Number parse;
        try {
            parse = format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0D;
        }
        return parse.doubleValue();
    }

    public Map<String, Boolean> unitTestPackageResults() {
        return unitTestResults;
    }

    public Map<String, Double> unitTestPackageTimes() {
        return unitTestTimes;
    }

    public Map<String, Double> functionAndLoadTestTimes() {
        return functionTestTimes;
    }

    public Map<String, Boolean> functionAndLoadTestResults() {
        return functionTestResults;
    }
}