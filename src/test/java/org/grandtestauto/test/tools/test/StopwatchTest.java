package org.grandtestauto.test.tools.test;

import org.grandtestauto.test.tools.Stopwatch;
import org.grandtestauto.test.tools.Waiting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

/**
 * @author Tim Lavers & Fede Lopez
 */
public class StopwatchTest {

    public boolean startTest() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Waiting.pause(100);
        stopwatch.stop();
        assertThat(stopwatch.times()).hasSize(1);
        assertThat(stopwatch.times().get(0)).isCloseTo(100, withinPercentage(5));
        return true;
    }

    public boolean stopTest() throws Exception {
        //Check that it is ok to stop an already stopped stopwatch.
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Waiting.pause(10);
        stopwatch.stop();
        stopwatch.stop();
        stopwatch.stop();
        stopwatch.stop();
        assertThat(stopwatch.times()).hasSize(1);
        return true;
    }

    public boolean stopWithoutStartTest() throws Exception {
        //Check that it is ok to stop a stopwatch even if it has not been started.
        Stopwatch stopwatch = new Stopwatch();
        Waiting.pause(10);
        stopwatch.stop();
        assertThat(stopwatch.times()).hasSize(1);
        assertThat(stopwatch.times().get(0)).isEqualTo(0);
        return true;
    }

    public boolean timesTest() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Waiting.pause(50);
        stopwatch.stop();
        stopwatch.start();
        Waiting.pause(50);
        stopwatch.stop();
        assertThat(stopwatch.times()).hasSize(2);
        return true;
    }

    public boolean maxTest() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Waiting.pause(50);
        stopwatch.stop();
        stopwatch.start();
        Waiting.pause(210);
        stopwatch.stop();
        stopwatch.start();
        Waiting.pause(10);
        stopwatch.stop();
        assertThat(stopwatch.max()).isCloseTo(210, withinPercentage(5));
        return true;
    }

    public boolean toStringTest() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Waiting.pause(50);
        stopwatch.stop();
        stopwatch.start();
        Waiting.pause(210);
        stopwatch.stop();
        stopwatch.start();
        Waiting.pause(10);
        stopwatch.stop();
        assertThat(stopwatch.toString().split(";")).hasSize(3);
        return true;
    }

}
