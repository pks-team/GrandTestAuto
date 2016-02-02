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
        String message = MessageFormat.format("##teamcity[testFailed name=''{0}'' message=''{1}'' details=''{2}'']", testName, escape(msg), escape(details));
        System.out.println(message);
    }

    /**
     * For escaped values, TeamCity uses a vertical bar "|" as an escape character.
     * In order to have certain characters properly interpreted by the TeamCity server, they must be preceded by a vertical bar.
     */
    private static String escape(String text) {
        return text.replaceAll("\\|", "||")
                .replaceAll("'", "|'")
                .replaceAll("\\[", "|[")
                .replaceAll("\\]", "|]")
                .replaceAll("\n", "|n")
                .replaceAll("\r", "|r");
    }
}
