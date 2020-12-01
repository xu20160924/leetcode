package com.john;

import java.util.concurrent.TimeUnit;

/**
 * @author: John
 * @date: 2020-10-23 12:33
 * @description: https://lexburner.github.io/cache-line/
 **/
public class FalseSharing implements Runnable {

    public final static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        runTest();
        System.out.println("duration = " + (System.currentTimeMillis() - start));
    }

    public FalseSharing(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }


    @Override
    public void run() {
        long i = ITERATIONS + 1;
        System.out.println("current Thread: " + Thread.currentThread());
        System.out.println("i: " + i);
        while (0 != --i) {
            longs[arrayIndex].value = i;
//            System.out.println(longs[arrayIndex].value);
        }
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i), i + "-thread");
        }
        for (Thread t : threads) {
            t.start();
            TimeUnit.SECONDS.sleep(1);
        }
        for (Thread t : threads) {
            t.join();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public final static class VolatileLong {
        public volatile long value = 0L;
//        public long p1, p2, p3, p4, p5, p6; // 填充
    }
}
