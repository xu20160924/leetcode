package com.john;

import java.util.concurrent.*;

/**
 * @author: John
 * @date: 2020-10-20 16:45
 * @description:
 **/
public class Synchronized {
//    public synchronized void husband() {
//        synchronized (new Object()) {
//
//        }
//    }

    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 5; i++) {
//            String str = i + "";
//            service.execute(() -> {
//                System.out.println(str);
//            });
//            System.out.println(service.isShutdown());
//        }
//        service.shutdown();
//        System.out.println("current thread pool state: " + service.isTerminated());
//        System.out.println("current thread pool state: " + service.isTerminated());
//        System.out.println("current thread pool state: " + service.isTerminated());
//        System.out.println("current thread pool state: " + service.isTerminated());
//        System.out.println("current thread pool state: " + service.isTerminated());
//        System.out.println("线程池已关闭");
//
//        while (true) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(service.isTerminated());
//        }
//        ForkJoinPool fjp = new ForkJoinPool(4);

    }

    public int num = 0;
    public void methodA() {
        System.out.println("methodA()...");
        methodB();
        num++;
    }
    public void methodB() {
        System.out.println("methodB()...");
    }
}