package org.grandtestauto.test.functiontest;

import org.grandtestauto.assertion.Assert;
import org.grandtestauto.test.Helpers;
import org.grandtestauto.test.dataconstants.org.grandtestauto.Grandtestauto;
import org.grandtestauto.test.tools.Waiting;

import java.io.File;

/**
 * @author Tim Lavers
 */
public class RunUnitTestMethodsAnnotatedAsTest extends FTBase {

    public boolean runTest() {
        boolean passed = Helpers.setupForZip(new File(Grandtestauto.test140_zip), true, true, true).runAllTests();
        String logFileContents = Helpers.logFileContents();
        Assert.azzert(logFileContents.contains("ATest"));
        Assert.azzert(logFileContents.contains("aTest"));
        Assert.azzert(logFileContents.contains("b"));
        Assert.azzert(testsRun.contains("a140.test.ATest"));
        Assert.azzert(passed);
        return true;
    }
}
