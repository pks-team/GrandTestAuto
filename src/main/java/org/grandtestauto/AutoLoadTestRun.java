/****************************************************************************
 * Name: Accountant.java
 * <p>
 * Synopsis: See javadoc class comments.
 * <p>
 * Description: See javadoc class comments.
 * <p>
 * Copyright 2002 Timothy Gordon Lavers (Australia)
 * <p>
 * The Wide Open License (WOL)
 * <p>
 * Permission to use, copy, modify, distribute and sell this software and its
 * documentation for any purpose is hereby granted without fee, provided that
 * the above copyright notice and this license appear in all source copies.
 * THIS SOFTWARE IS PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF
 * ANY KIND. See http://www.dspguru.com/wol.htm for more information.
 *****************************************************************************/
package org.grandtestauto;

import org.grandtestauto.test.tools.TestHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Runs a single <code>AutoLoadTest</code>.
 *
 * @author Tim Lavers
 */
class AutoLoadTestRun {
    @NotNull
    private String fullClassName;
    @NotNull
    private String testName;

    @Nullable
    private GTALogger resultsLogger;
    private boolean teamCityLoggingEnabled;

    AutoLoadTestRun(@NotNull String fullClassName, @NotNull String testName, @Nullable GTALogger resultsLogger, boolean teamCityLoggingEnabled) {
        this.fullClassName = fullClassName;
        this.testName = testName;
        this.resultsLogger = resultsLogger;
        this.teamCityLoggingEnabled = teamCityLoggingEnabled;
    }

    boolean runAutoLoadTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> klass = Class.forName(fullClassName);
        int repeats = StaticUtils.flakyRepeats(klass);
        Integer secondsToPauseIfTestThrowsException = StaticUtils.pauseOnException(klass);
        AutoLoadTest ft = (AutoLoadTest) klass.newInstance();
        //Report the result.
        boolean resultForTest = false;
        long timeJustBeforeTestRun = 0;
        long timeJustAfterTestRun = 0;
        if (teamCityLoggingEnabled) TeamCityOutputLogger.logTestStarted(testName);
        for (int i = 1; !resultForTest && i <= repeats; i++) {
            if (i > 1) {
                StaticUtils.printAndLog(null, Messages.message(Messages.TPK_RUNNING_TEST_AGAIN, testName, "" + i), resultsLogger);
            }
            timeJustBeforeTestRun = System.currentTimeMillis();
            String msg = Messages.message(Messages.OPK_ERROR_RUNNING_AUTO_LOAD_TEST, testName);
            try {
                resultForTest = ft.runTest();
                if (!resultForTest && teamCityLoggingEnabled && i == repeats) {
                    TeamCityOutputLogger.logTestFailed(testName, msg, "");
                }
            } catch (Throwable e) {
                StaticUtils.printAndLog(e, msg, resultsLogger);
                if (teamCityLoggingEnabled && i == repeats) {
                    TeamCityOutputLogger.logTestFailed(testName, msg, TestHelper.toString(e));
                }
                if (secondsToPauseIfTestThrowsException != null) {
                    String pauseMessage = Messages.message(Messages.OPK_PAUSING_TEST_THAT_THREW_ERROR, secondsToPauseIfTestThrowsException.toString());
                    StaticUtils.printAndLog(null, pauseMessage, resultsLogger);
                    StaticUtils.pauseOnException(secondsToPauseIfTestThrowsException, resultsLogger);
                }
            }
            timeJustAfterTestRun = System.currentTimeMillis();
        }
        long timeToRunTest = timeJustAfterTestRun - timeJustBeforeTestRun;
        String msg = testName + " " + Messages.passOrFail(resultForTest) + ", " + ResultsLogger.formatTestExecutionTime(timeToRunTest);
        StaticUtils.printAndLog(null, msg, resultsLogger);
        if (teamCityLoggingEnabled) TeamCityOutputLogger.logTestFinished(testName, timeToRunTest);
        return resultForTest;
    }
}