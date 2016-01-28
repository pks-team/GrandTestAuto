package org.grandtestauto.test.tools.test;

/**
 * @author Tim Lavers & FedericoL
 */
class Counter implements Runnable {

    public Counter() {
    }

    public Counter(long limit) {
        this.limit = limit;
    }

    long count = 0;
    long limit = 100;
    int callsMade = 0;

    long getCount() {
        callsMade++;
        return count;
    }

    @Override public void run() {
        while (count < limit) {
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
