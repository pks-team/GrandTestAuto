package org.grandtestauto.test.functiontest;

import org.grandtestauto.assertion.Assert;
import org.grandtestauto.test.Helpers;
import org.grandtestauto.test.dataconstants.org.grandtestauto.Grandtestauto;
import org.grandtestauto.test.tools.Waiting;

import java.io.File;

/**
 * @author Tim Lavers
 */
public class SpecifyAnnotatedUnitTestUsingSettings extends FTBase {

    public boolean runTest() {
        boolean passed = Helpers.setupForZip(new File(Grandtestauto.test140_zip), true, false, false, null, null, "a140", false, true, Helpers.defaultLogFile().getPath(),
                false, null, null, "ATest", null,null, null).runAllTests();
        String logFileContents = Helpers.logFileContents();
        Waiting.pause(1000);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("logFileContents = " + logFileContents);
        System.out.println();
        System.out.println();
        System.out.println();
        Waiting.pause(1000);
        Assert.azzert(logFileContents.contains("ATest"));
        Assert.azzert(logFileContents.contains("aTest passed"));
        Assert.azzert(logFileContents.contains("b passed"));
        Assert.azzert(passed);

        passed = Helpers.setupForZip(new File(Grandtestauto.test140_zip), true, false, false, null, null, "a140", false, true, Helpers.defaultLogFile().getPath(),
                false, null, null, "ATest", null,null, "aTest").runAllTests();
        logFileContents = Helpers.logFileContents();
        Waiting.pause(1000);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("logFileContents = " + logFileContents);
        System.out.println();
        System.out.println();
        System.out.println();
        Waiting.pause(1000);
        Assert.azzert(logFileContents.contains("ATest"));
        Assert.azzert(logFileContents.contains("aTest passed"));
        Assert.azzertFalse(logFileContents.contains("b passed"));
        Assert.azzertFalse(logFileContents.contains("b failed"));
        Assert.azzert(passed);

        passed = Helpers.setupForZip(new File(Grandtestauto.test140_zip), true, false, false, null, null, "a140", false, true, Helpers.defaultLogFile().getPath(),
                false, null, null, "ATest", null,null, "b").runAllTests();
        logFileContents = Helpers.logFileContents();
        Waiting.pause(1000);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("logFileContents = " + logFileContents);
        System.out.println();
        System.out.println();
        System.out.println();
        Waiting.pause(1000);
        Assert.azzert(logFileContents.contains("ATest"));
        Assert.azzertFalse(logFileContents.contains("aTest"));
        Assert.azzert(logFileContents.contains("b passed"));
        Assert.azzert(passed);
        return true;
    }
}
