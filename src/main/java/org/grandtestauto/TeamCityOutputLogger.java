package org.grandtestauto;

import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;

/**
 * @author Tim Lavers & Fede Lopez
 */
public class TeamCityOutputLogger implements GTALogger {

    @Override
    public void log(String message, @Nullable Throwable t) {

    }

    @Override
    public void logSuiteStarted(String suiteName) {
        String message = MessageFormat.format("##teamcity[testSuiteStarted name=''{0}'']", suiteName);
        System.out.println(message);
    }

    @Override
    public void logSuiteFinished(String suiteName) {
        String message = MessageFormat.format("##teamcity[testSuiteFinished name=''{0}'']", suiteName);
        System.out.println(message);
    }

    @Override
    public void logTestStarted(String testName) {
        String message = MessageFormat.format("##teamcity[testStarted name=''{0}'' captureStandardOutput=''true'']", testName);
        System.out.println(message);
    }

    @Override
    public void logTestFinished(String testName, long duration) {
        String message = MessageFormat.format("##teamcity[testFinished name=''{0}'' duration=''{1}'']", testName, duration);
        System.out.println(message);
    }

    @Override
    public void closeLogger() {

    }
}
