package org.grandtestauto.test.tools.test;

import org.assertj.core.api.Assertions;
import org.grandtestauto.test.tools.Waiting;

import static org.assertj.core.api.Assertions.withinPercentage;

/**
 * @author Tim Lavers & Fede Lopez
 */
public class WaitingTest {

    public boolean pauseTest() throws Exception {
        long initial = System.currentTimeMillis();
        Waiting.pause(100);
        long now = System.currentTimeMillis();
        Assertions.assertThat(now - initial).isCloseTo(100, withinPercentage(5));
        return true;
    }

    public boolean waitFor_Waiting$ItHappened_long_Test() throws Exception {
        Counter counter = new Counter();
        Thread counterThread = new Thread(counter);
        counterThread.start();
        boolean actual = Waiting.waitFor(() -> counter.count > 10, 1000);
        counterThread.join();
        Assertions.assertThat(actual).isTrue();
        return true;
    }

    public boolean waitFor_Waiting$ItHappened_long_long_Test() throws Exception {
        Counter counter = new Counter();
        Thread counterThread = new Thread(counter);
        counterThread.start();
        boolean actual = Waiting.waitFor(() -> counter.getCount() > 10, 1000, 5);
        counterThread.join();
        Assertions.assertThat(counter.callsMade).isCloseTo(100, withinPercentage(20));
        Assertions.assertThat(actual).isTrue();
        return true;
    }

    public boolean stopTest() throws Exception {
        return true;
    }

}
