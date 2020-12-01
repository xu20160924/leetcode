package com.john;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * @author: John
 * @date: 2020-10-19 14:17
 * @description: join
 **/
public class Join {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
//        test2();
//        test1();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
        Join join = new Join();
        join.test8();
    }

    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });

        Thread t2 = new Thread(() -> {
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2 = 20;
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        long end = System.currentTimeMillis();
        System.out.println("r1:" + r1 + " r2:" + r2 + " cost:" + (end - start));
    }

    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
//        long start = System.currentTimeMillis();
        t1.start();
        // 主线程休眠0.5秒 让t1充分运行
        sleep((long) 0.5);
        t1.interrupt();
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
        System.out.println("打断状态:" + t1.isInterrupted());
    }

    public static void test3() throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        // 休眠5秒, 让sleepThread 和busyThread 充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static void test4() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if (interrupted) {
                    System.out.println("interrupt status " + interrupted);
                    break;
                }
            }
        }, "t2");

        t2.start();
        sleep((long) 0.5);
        t2.interrupt();
    }

//    public static void test5() throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            System.out.println("park...");
//            LockSupport.park();
//            System.out.println("unpark...");
//            System.out.println("打断状态 " + Thread.currentThread().isInterrupted());
//
//        }, "t1");
//        t1.start();
//        sleep((long) 0.5);
//        t1.interrupt();
//    }

    public static void test6() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("park...");
                System.out.println(i);
                LockSupport.park();

                System.out.println("打断状态 " + Thread.currentThread().isInterrupted());
            }
        });
        t1.start();
        sleep(1);
        t1.interrupt();
    }

    public static void test7() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("enter t1");
            try {
                sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("park 1");
            LockSupport.park();
            System.out.println("park 2");
        }, "t1");
        t1.start();

        LockSupport.unpark(t1);
        System.out.println("unpark 1");
        sleep(10000L);
        LockSupport.unpark(t1);
        System.out.println("unpark 2");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    Object A = new Object();
    Object B = new Object();

    public void test8() {
        Thread t1 = new Thread(()-> {
            synchronized (A) {
                System.out.println("lock A");
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("lock B");
                    System.out.println("操作...");
                }
            }
        }, "t1");

        Thread t2 = new Thread(()-> {
            synchronized (B) {
                System.out.println("lock B");
                try {
                    sleep((long) 0.5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("lock A");
                    System.out.println("操作...");
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }


}
