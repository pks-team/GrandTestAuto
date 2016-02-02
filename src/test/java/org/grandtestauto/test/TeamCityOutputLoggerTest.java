package org.grandtestauto.test;

import org.grandtestauto.Cleanup;
import org.grandtestauto.TeamCityOutputLogger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author @author Tim Lavers
 */
public class TeamCityOutputLoggerTest {

    private PrintStream originalPrintStream;
    private ByteArrayOutputStream testOutputStream;

    public boolean logSuiteStartedTest() throws IOException {
        init();
        TeamCityOutputLogger.logSuiteStarted("MySuite");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testSuiteStarted name='MySuite']");
        cleanup();
        return true;
    }

    public boolean logSuiteFinishedTest() throws IOException {
        init();
        TeamCityOutputLogger.logSuiteFinished("MySuite");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testSuiteFinished name='MySuite']");
        cleanup();
        return true;
    }

    public boolean logTestStartedTest() throws IOException {
        init();
        TeamCityOutputLogger.logTestStarted("constructorTest");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testStarted name='constructorTest' captureStandardOutput='true']");
        cleanup();
        return true;
    }

    public boolean logTestFinishedTest() throws IOException {
        init();
        TeamCityOutputLogger.logTestFinished("constructorTest", 20);
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFinished name='constructorTest' duration='20']");
        cleanup();
        return true;
    }

    public boolean logTestFailedTest() throws IOException {
        init();
        TeamCityOutputLogger.logTestFailed("constructorTest", "Assertion error", "expected 4, got 5");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='constructorTest' message='Assertion error' details='expected 4, got 5']");
        cleanup();
        return true;
    }

    public boolean logTestFailedInlinesStackTraceTest() throws IOException {
        init();

        String message = "AssertionFailedError: expected:<20000> but was:<10000>\n\r Assert.fail(Assert.java:47) \n\r Check your code!";
        String expected = "AssertionFailedError: expected:<20000> but was:<10000>|n|r Assert.fail(Assert.java:47) |n|r Check your code!";

        TeamCityOutputLogger.logTestFailed("constructorTest", "Assertion error", message);

        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='constructorTest' message='Assertion error' details='" + expected + "']");
        cleanup();
        return true;
    }

    public boolean shouldEscapeApostropheOnErrorMessageTest() throws Exception {
        init();
        String text = "java.lang.AssertionError: expected '3' but was '5'";
        TeamCityOutputLogger.logTestFailed("ServerUpgrade", text, "java.lang.AssertionFailedError");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='ServerUpgrade' message='java.lang.AssertionError: expected |'3|' but was |'5|'' details='java.lang.AssertionFailedError']");
        cleanup();
        return true;
    }

    public boolean shouldEscapeApostropheOnErrorDetailsTest() throws Exception {
        init();
        String quotedMessage = "java.lang.AssertionError: Current version '7.3.0' was not found in S3";
        TeamCityOutputLogger.logTestFailed("ServerUpgrade", "Assertion error", quotedMessage);
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='ServerUpgrade' message='Assertion error' details='java.lang.AssertionError: Current version |'7.3.0|' was not found in S3']");
        cleanup();
        return true;
    }

    public boolean shouldEscapeVerticalBarOnErrorMessageTest() throws Exception {
        init();
        String text = "AssertionError: expected |3| but was |5|";
        TeamCityOutputLogger.logTestFailed("ServerUpgrade", text, "AssertionFailedError");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='ServerUpgrade' message='AssertionError: expected ||3|| but was ||5||' details='AssertionFailedError']");
        cleanup();
        return true;
    }

    public boolean shouldEscapeVerticalBarOnErrorDetailsTest() throws Exception {
        init();
        String text = "Current version |7.3.0| was not found in S3";
        TeamCityOutputLogger.logTestFailed("ServerUpgrade", "Assertion error", text);
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='ServerUpgrade' message='Assertion error' details='Current version ||7.3.0|| was not found in S3']");
        cleanup();
        return true;
    }

    public boolean shouldEscapeBracketsOnErrorMessageTest() throws Exception {
        init();
        String text = "AssertionError: expected [3] but was [5]";
        TeamCityOutputLogger.logTestFailed("ServerUpgrade", text, "AssertionFailedError");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='ServerUpgrade' message='AssertionError: expected |[3|] but was |[5|]' details='AssertionFailedError']");
        cleanup();
        return true;
    }

    public boolean shouldEscapeBracketsOnErrorDetailsTest() throws Exception {
        init();
        String text = "Current version [7.3.0] was not found in S3";
        TeamCityOutputLogger.logTestFailed("ServerUpgrade", "Assertion error", text);
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='ServerUpgrade' message='Assertion error' details='Current version |[7.3.0|] was not found in S3']");
        cleanup();
        return true;
    }

    private void init() {
        originalPrintStream = System.out;
        testOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOutputStream);
        System.setOut(printStream);
    }

    @Cleanup
    private void cleanup() {
        if (originalPrintStream != null) {
            System.setOut(originalPrintStream);
        }
    }

}