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

    //todo: trim is necessary, impacts on actual stack?

    public boolean logSuiteStartedTest() throws IOException {
        init();
        TeamCityOutputLogger logger = new TeamCityOutputLogger();
        logger.logSuiteStarted("MySuite");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testSuiteStarted name='MySuite']");
        cleanup();
        return true;
    }

    public boolean logSuiteFinishedTest() throws IOException {
        init();
        TeamCityOutputLogger logger = new TeamCityOutputLogger();
        logger.logSuiteFinished("MySuite");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testSuiteFinished name='MySuite']");
        cleanup();
        return true;
    }

    public boolean logTestStartedTest() throws IOException {
        init();
        TeamCityOutputLogger logger = new TeamCityOutputLogger();
        logger.logTestStarted("constructorTest");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testStarted name='constructorTest' captureStandardOutput='true']");
        cleanup();
        return true;
    }

    public boolean logTestFinishedTest() throws IOException {
        init();
        TeamCityOutputLogger logger = new TeamCityOutputLogger();
        logger.logTestFinished("constructorTest", 20);
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFinished name='constructorTest' duration='20']");
        cleanup();
        return true;
    }

    public boolean logTestFailedTest() throws IOException {
        init();
        TeamCityOutputLogger logger = new TeamCityOutputLogger();
        logger.logTestFailed("constructorTest", "Assertion error", "expected 4, got 5");
        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='constructorTest' message='Assertion error' details='expected 4, got 5']");
        cleanup();
        return true;
    }

    public boolean logTestFailedInlinesStackTraceTest() throws IOException {
        init();
        TeamCityOutputLogger logger = new TeamCityOutputLogger();

        String message = "AssertionFailedError: expected:<20000> but was:<10000>\n\r Assert.fail(Assert.java:47) \n\r Check your code!";
        String expected = "AssertionFailedError: expected:<20000> but was:<10000>|n|r Assert.fail(Assert.java:47) |n|r Check your code!";

        logger.logTestFailed("constructorTest", "Assertion error", message);

        String actual = testOutputStream.toString();
        assertThat(actual.trim()).isEqualTo("##teamcity[testFailed name='constructorTest' message='Assertion error' details='" + expected + "']");
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