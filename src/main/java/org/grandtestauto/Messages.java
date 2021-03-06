/****************************************************************************
 *
 * Name: Messages.java
 *
 * Synopsis: See javadoc class comments.
 *
 * Description: See javadoc class comments.
 *
 * Copyright 2002 Timothy Gordon Lavers (Australia)
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
package org.grandtestauto;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Messages to the user, based on a properties file.
 *
 * @author Tim Lavers
 */
public class Messages {

    public static final String SK_BUG_IN_GTA = "SK_BUG_IN_GTA";
    public static final String SK_FAILED = "SK_FAILED";
    public static final String OPK_CLEANUP_THREW_THROWABLE = "OPK_CLEANUP_THREW_THROWABLE";
    public static final String SK_CLEANUP_NOT_PUBLIC = "SK_CLEANUP_NOT_PUBLIC";
    public static final String SK_CLEANUP_NOT_NO_ARGS = "SK_CLEANUP_NOT_NO_ARGS";
    public static final String SK_GTA_COULD_NOT_RUN = "SK_GTA_COULD_NOT_RUN";
    public static final String SK_GTA_NEEDS_TWO_ARGUMENTS = "SK_GTA_NEEDS_TWO_ARGUMENTS";
    public static final String SK_PASSED = "SK_PASSED";
    public static final String SK_TEST_FAILED_DUE_TO_EXCEPTION = "SK_TEST_FAILED_DUE_TO_EXCEPTION";
    public static final String SK_WILL_RUN_UNIT_TESTS = "SK_WILL_RUN_UNIT_TESTS";
    public static final String SK_WILL_NOT_RUN_UNIT_TESTS = "SK_WILL_NOT_RUN_UNIT_TESTS";
    public static final String SK_WILL_RUN_FUNCTION_TESTS = "SK_WILL_RUN_FUNCTION_TESTS";
    public static final String SK_WILL_NOT_RUN_FUNCTION_TESTS = "SK_WILL_NOT_RUN_FUNCTION_TESTS";
    public static final String SK_WILL_RUN_LOAD_TESTS = "SK_WILL_RUN_LOAD_TESTS";
    public static final String SK_WILL_NOT_RUN_LOAD_TESTS = "SK_WILL_NOT_RUN_LOAD_TESTS";
    public static final String SK_RUNNING_UNIT_TESTS = "SK_RUNNING_UNIT_TESTS";
    public static final String SK_RUNNING_FUNCTION_TESTS = "SK_RUNNING_FUNCTION_TESTS";
    public static final String SK_RUNNING_LOAD_TESTS = "SK_RUNNING_LOAD_TESTS";
    public static final String SK_FAIL_FAST = "SK_FAIL_FAST";
    public static final String SK_TEAMCITY_OUTPUT = "SK_TEAMCITY_OUTPUT";
    public static final String SK_FAIL_FAST_UNIT_TESTS = "SK_FAIL_FAST_UNIT_TESTS";
    public static final String SK_FAIL_FAST_FUNCTION_TESTS = "SK_FAIL_FAST_FUNCTION_TESTS";
    public static final String SK_FAIL_FAST_SKIP_FUNCTION_TESTS = "SK_FAIL_FAST_SKIP_FUNCTION_TESTS";
    public static final String SK_FAIL_FAST_LOAD_TESTS = "SK_FAIL_FAST_LOAD_TESTS";
    public static final String SK_FAIL_FAST_SKIP_LOAD_TESTS = "SK_FAIL_FAST_SKIP_LOAD_TESTS";
    public static final String SK_ABOUT_TO_RUN_TESTS = "SK_ABOUT_TO_RUN_TESTS";
    public static final String SK_GTA_CONTINUING_WITH_SETTINGS_THAT_COULD_BE_READ = "SK_GTA_CONTINUING_WITH_SETTINGS_THAT_COULD_BE_READ";
    public static final String SK_SINGLE_PACKAGE_NOT_SPECIFIED = "SK_SINGLE_PACKAGE_NOT_SPECIFIED";
    public static final String SK_RUNNING_FUNCTION_OR_LOAD_TESTS_PATTERN = "SK_RUNNING_FUNCTION_OR_LOAD_TESTS_PATTERN";
    public static final String SK_LOG_FILES = "SK_LOG_FILES";
    public static final String SK_ALL_OK = "SK_ALL_OK";
    public static final String SK_TESTING_PROBLEMS = "SK_TESTING_PROBLEMS";

    public static final String OPK_SETTINGS_FILE_NOT_FOUND_SO_WRITTEN = "OPK_SETTINGS_FILE_NOT_FOUND_SO_WRITTEN";
    public static final String OPK_SETTINGS_FILE_HAS_PROBLEMS = "OPK_SETTINGS_FILE_HAS_PROBLEMS";
    public static final String OPK_CORRECTED_SETTINGS_FILE_WRITTEN = "OPK_CORRECTED_SETTINGS_FILE_WRITTEN";
    public static final String OPK_COULD_NOT_OPEN_RESULTS_FILE = "OPK_COULD_NOT_OPEN_RESULTS_FILE";

    public static final String OPK_COULD_NOT_CREATE_TEST_CLASS = "OPK_COULD_NOT_CREATE_TEST_CLASS";
    public static final String OPK_COULD_NOT_FIND_CLASS = "OPK_COULD_NOT_FIND_CLASS";
    public static final String OPK_COULD_NOT_FIND_UNIT_TESTER = "OPK_COULD_NOT_FIND_UNIT_TESTER";
    public static final String OPK_COULD_NOT_CREATE_UNIT_TESTER = "OPK_COULD_NOT_CREATE_UNIT_TESTER";
    public static final String OPK_COULD_NOT_RUN_TEST_METHOD = "OPK_COULD_NOT_RUN_TEST_METHOD";
    public static final String OPK_OVERALL_UNIT_TEST_RESULT = "OPK_OVERALL_UNIT_TEST_RESULT";
    public static final String OPK_OVERALL_GTA_RESULT = "OPK_OVERALL_GTA_RESULT";
    public static final String OPK_TEST_METHOD_DOES_NOT_RETURN_BOOLEAN = "OPK_TEST_METHOD_DOES_NOT_RETURN_BOOLEAN";
    public static final String OPK_UNIT_TESTER_NOT_UNITTESTERIF = "OPK_UNIT_TESTER_NOT_UNITTESTERIF";
    public static final String OPK_UNIT_TESTER_DOES_NOT_HAVE_REQURIED_CONSTRUCTOR = "OPK_UNIT_TESTER_DOES_NOT_HAVE_REQURIED_CONSTRUCTOR";
    public static final String OPK_UNIT_TESTER_NOT_PUBLIC = "OPK_UNIT_TESTER_NOT_PUBLIC";
    public static final String OPK_UNIT_TESTER_ABSTRACT = "OPK_UNIT_TESTER_ABSTRACT";
    public static final String OPK_AUTO_LOAD_TEST_DOES_NOT_HAVE_REQURIED_CONSTRUCTOR = "OPK_AUTO_LOAD_TEST_DOES_NOT_HAVE_REQURIED_CONSTRUCTOR";
    public static final String OPK_NO_RESULTS_FOUND_FOR = "OPK_NO_RESULTS_FOUND_FOR";
    public static final String OPK_UNIT_TESTS_FAILED_FOR = "OPK_UNIT_TESTS_FAILED_FOR";
    public static final String OPK_ONE_OR_MORE_TESTS_FAILED_IN = "OPK_ONE_OR_MORE_TESTS_FAILED_IN";
    public static final String OPK_NUMBER_OF_AUTOLOAD_TESTS = "OPK_NUMBER_OF_AUTOLOAD_TESTS";
    public static final String OPK_NUMBER_OF_UNIT_TEST_PACKAGES = "OPK_NUMBER_OF_UNIT_TEST_PACKAGES";

    public static final String OPK_RUNNING_FUNCTION_TEST_PACKAGE = "OPK_RUNNING_FUNCTION_TEST_PACKAGE";
    public static final String OPK_RUNNING_LOAD_TEST_PACKAGE = "OPK_RUNNING_LOAD_TEST_PACKAGE";
    public static final String OPK_ERROR_RUNNING_AUTO_LOAD_TEST = "OPK_ERROR_RUNNING_AUTO_LOAD_TEST";
    public static final String OPK_ERROR_RUNNING_UNIT_TESTER_TEST = "OPK_ERROR_RUNNING_UNIT_TESTER_TEST";

    public static final String OPK_PAUSING_TEST_THAT_THREW_ERROR = "OPK_PAUSING_TEST_THAT_THREW_ERROR";

    public static final String OPK_OVERALL_FUNCTION_TEST_RESULT = "OPK_OVERALL_FUNCTION_TEST_RESULT";
    public static final String OPK_OVERALL_LOAD_TEST_RESULT = "OPK_OVERALL_LOAD_TEST_RESULT";
    public static final String OPK_CLASSES_DIRECTORY_DOES_NOT_EXIST = "OPK_CLASSES_DIRECTORY_DOES_NOT_EXIST";
    public static final String OPK_UNIT_TEST_COVERAGE_COMPLETE = "OPK_UNIT_TEST_COVERAGE_COMPLETE";
    public static final String OPK_PROBLEMS_WITH_UNIT_TEST_COVERAGE = "OPK_PROBLEMS_WITH_UNIT_TEST_COVERAGE";
    public static final String OPK_LOG_FILE_DIRECTORY = "OPK_LOG_FILE_DIRECTORY";

    public static final String TPK_UNIT_TEST_PACK_RESULTS = "TPK_UNIT_TEST_PACK_RESULTS";
    public static final String TPK_FUNCTION_TEST_PACK_RESULTS = "TPK_FUNCTION_TEST_PACK_RESULTS";
    public static final String TPK_LOAD_TEST_PACK_RESULTS = "TPK_LOAD_TEST_PACK_RESULTS";
    public static final String TPK_RUNNING_TEST_AGAIN = "TPK_RUNNING_TEST_AGAIN";

    public static final String CK_CONSTRUCTOR_TESTS_EXPECTED = "CK_CONSTRUCTOR_TESTS_EXPECTED";
    public static final String CK_PACKAGE_NOT_UNIT_TESTED = "CK_PACKAGE_NOT_UNIT_TESTED";

    public static final String TPK_CK_CLASSES_NOT_TESTED = "TPK_CK_CLASSES_NOT_TESTED";
    public static final String TPK_CK_METHODS_NOT_TESTED = "TPK_CK_METHODS_NOT_TESTED";

    //Single instance.
    private static Messages instance = new Messages();

    //The keys and values, backed by a properties file.
    private ResourceBundle resources;

    //Private constructor for singleton.
    private Messages() {
        resources = ResourceBundle.getBundle(getClass().getName());
    }

    /**
     * Translation of the given key string.
     */
    public static String message(String key) {
        return instance.resources.getString(key);
    }

    /**
     * Formatted translation of the given key string, with <code>arg</code>
     * in the parameter slot.
     */
    public static String message(String key, String arg) {
        return MessageFormat.format(instance.resources.getString(key), arg);
    }

    /**
     * Formatted translation of te given key string, with <code>arg1</code> and <code>arg2</code>
     * in the parameter slots.
     */
    public static String message(String key, String arg1, String arg2) {
        return MessageFormat.format(instance.resources.getString(key), arg1, arg2);
    }

    /**
     * The new line char.
     */
    public static String nl() {
        return System.getProperty("line.separator");
    }

    /**
     * The message for <code>key</code>, grammatically correct
     * for the given <code>plurality</code>.
     */
    public static String message(String key, int plurality) {
        double[] limits = {1, 2};
        String[] strings = {instance.resources.getString(key + "_CHOICE_0"),
                            instance.resources.getString(key + "_CHOICE_1")};
        ChoiceFormat choiceForm = new ChoiceFormat(limits, strings);

        MessageFormat formatter = new MessageFormat("");
        formatter.applyPattern(instance.resources.getString(key));
        formatter.setFormats(new Format[]{choiceForm});
        return formatter.format(new Object[]{plurality});
    }

    /**
     * The message for <code>key</code>, with placeholder replaced by
     * <code>arg</code>, and grammatically correct
     * for the given <code>plurality</code>.
     */
    public static String message(String key, String arg, int plurality) {
        double[] limits = {1, 2};
        String[] strings = {instance.resources.getString(key + "_CHOICE_0"),
                            instance.resources.getString(key + "_CHOICE_1")};
        ChoiceFormat choiceForm = new ChoiceFormat(limits, strings);

        MessageFormat formatter = new MessageFormat("");
        formatter.applyPattern(instance.resources.getString(key));
        formatter.setFormats(new Format[]{null, choiceForm});
        return formatter.format(new Object[]{arg, plurality});
    }

    /**
     * Translation of <code>SK_PASSED</code> or <code>SK_FAILED</code> according to
     * the value of <code>trueForPass</code>.
     */
    public static String passOrFail(boolean trueForPass) {
        String result;
        if (trueForPass) {
            result = Messages.message(Messages.SK_PASSED);
        } else {
            result = Messages.message(Messages.SK_FAILED);
        }
        return result;
	}
}