package org.grandtestauto.test.tools.test;

import org.grandtestauto.test.Helpers;
import org.grandtestauto.test.tools.TestHelper;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tim Lavers & Fede Lopez
 */
public class TestHelperTest {

    public boolean namesOfActiveThreadsTest() throws Exception {
        Thread thread1 = new Thread(new Counter());
        thread1.setName("Counter1");
        Thread thread2 = new Thread(new Counter());
        thread2.setName("Counter2");

        Set<String> threads = TestHelper.namesOfActiveThreads();
        assertThat(threads).doesNotContain("Counter1", "Counter2");

        thread1.start();
        thread2.start();

        threads = TestHelper.namesOfActiveThreads();
        assertThat(threads).contains("Counter1", "Counter2");

        thread1.join();
        thread2.join();

        return true;
    }

    public boolean waitForNamedThreadToFinishTest() throws Exception {
        Thread thread = new Thread(new Counter(10));
        thread.setName("Counter1");
        thread.start();
        TestHelper.waitForNamedThreadToFinish(thread.getName(), 1000);
        assertThat(TestHelper.namesOfActiveThreads()).doesNotContain(thread.getName());
        return true;
    }

    public boolean printActiveThreadsTest() throws Exception {
        Thread thread = new Thread(new Counter(10));
        thread.setName("Kounter1");
        thread.start();
        Thread thread2 = new Thread(new Counter(10));
        thread2.setName("Kounter2");
        thread2.start();
        Helpers.startRecordingSout();

        TestHelper.printActiveThreads();

        String got = Helpers.stopRecordingSout();
        assertThat(got).contains(thread.getName(), thread2.getName());

        thread.join();
        thread2.join();
        return true;
    }

    public boolean toStringTest() throws Exception {
        String stackTrace = TestHelper.toString(new Throwable("Oups!"));
        assertThat(stackTrace).startsWith("java.lang.Throwable: Oups!");
        return true;
    }
}

