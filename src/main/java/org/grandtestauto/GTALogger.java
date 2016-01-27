package org.grandtestauto;

import org.jetbrains.annotations.Nullable;

/**
 * For logging test results and other testing messages.
 *
 * @author Tim Lavers
 */
public interface GTALogger {

    void log(String message, @Nullable Throwable t);

    void logSuiteStarted(String suiteName);

    void logSuiteFinished(String suiteName);

    void logTestStarted(String testName);

    void logTestFinished(String testName, long duration);

    void closeLogger();
}
