package org.grandtestauto.test.tools;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/**
 * The methods in this class are discussed in Chapter 14.
 */
public class TestHelper {

    /**
     * Private constructor as we don't want to instantiate this.
     */
    private TestHelper() {
    }

    public static Set<String> namesOfActiveThreads() {
        Set<String> result = new HashSet<>();
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            if (thread != null) {
                result.add(thread.getName());
            }
        }
        return result;
    }

    public static void printActiveThreads() {
        int activeCount = namesOfActiveThreads().size();
        System.out.println("Number of active Threads: " + activeCount);
        for (String name : namesOfActiveThreads()) {
            System.out.println(name);
        }
    }

    public static boolean waitForNamedThreadToFinish(final String threadName, long timeoutMillis) {
        return Waiting.waitFor(() -> !namesOfActiveThreads().contains(threadName), timeoutMillis);
    }

    public static String toString(Throwable throwable) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        throwable.printStackTrace(new PrintStream(stream));
        return new String(stream.toByteArray());
    }
}