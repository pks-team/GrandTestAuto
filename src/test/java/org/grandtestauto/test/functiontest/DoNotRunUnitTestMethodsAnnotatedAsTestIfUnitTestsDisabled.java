package org.grandtestauto.test.functiontest;

import org.grandtestauto.assertion.Assert;
import org.grandtestauto.test.Helpers;
import org.grandtestauto.test.dataconstants.org.grandtestauto.Grandtestauto;

import java.io.File;

/**
 * @author Tim Lavers
 */
public class DoNotRunUnitTestMethodsAnnotatedAsTestIfUnitTestsDisabled extends FTBase {

    public boolean runTest() {
        boolean passed = Helpers.setupForZip(new File(Grandtestauto.test140_zip), false, true, true).runAllTests();
        String logFileContents = Helpers.logFileContents();
        System.out.println("logFileContents = " + logFileContents);
        Assert.azzertFalse(logFileContents.contains("ATest"));
        Assert.azzertFalse(logFileContents.contains("aTest"));
        Assert.azzertFalse(logFileContents.contains("b passed"));
        Assert.azzertFalse(testsRun.contains("a140.test.ATest"));
        Assert.azzert(passed);
        return true;
    }
}
