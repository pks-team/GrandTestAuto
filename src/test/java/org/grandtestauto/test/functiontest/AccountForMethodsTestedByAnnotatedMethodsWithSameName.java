package org.grandtestauto.test.functiontest;

import org.grandtestauto.assertion.Assert;
import org.grandtestauto.test.Helpers;
import org.grandtestauto.test.dataconstants.org.grandtestauto.Grandtestauto;
import org.grandtestauto.test.tools.Waiting;

import java.io.File;

/**
 * @author Tim Lavers
 */
public class AccountForMethodsTestedByAnnotatedMethodsWithSameName extends FTBase {

    public boolean runTest() {
        boolean passed = Helpers.setupForZip(new File(Grandtestauto.test141_zip), true, true, true).runAllTests();
        Assert.azzert(passed);
        return true;
    }
}
