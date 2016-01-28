package org.grandtestauto;

import java.text.MessageFormat;

/**
 * @author Tim Lavers & Fede Lopez
 */
public class TeamCityOutputLogger {

    public static void logSuiteStarted(String suiteName) {
        String message = MessageFormat.format("##teamcity[testSuiteStarted name=''{0}'']", suiteName);
        System.out.println(message);
    }

    public static void logSuiteFinished(String suiteName) {
        String message = MessageFormat.format("##teamcity[testSuiteFinished name=''{0}'']", suiteName);
        System.out.println(message);
    }

    public static void logTestStarted(String testName) {
        String message = MessageFormat.format("##teamcity[testStarted name=''{0}'' captureStandardOutput=''true'']", testName);
        System.out.println(message);
    }

    public static void logTestFinished(String testName, long duration) {
        String message = MessageFormat.format("##teamcity[testFinished name=''{0}'' duration=''{1}'']", testName, duration);
        System.out.println(message);
    }

    public static void logTestFailed(String testName, String msg, String details) {
        String message = MessageFormat.format("##teamcity[testFailed name=''{0}'' message=''{1}'' details=''{2}'']", testName, msg, details);
        System.out.println(message.replaceAll("\n", "|n").replaceAll("\r", "|r"));
    }
}
