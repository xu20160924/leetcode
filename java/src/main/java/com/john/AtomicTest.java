package com.john;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {
//    static AtomicReference<Integer> money = new AtomicReference<>();
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int timestamp = money.getStamp();
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20, timestamp, timestamp +1)) {
                                    System.out.println("余额小于20，充值成功，余额："+money.getReference()+"元");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        int timeStamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10, timeStamp, timeStamp + 1)) {
                                System.out.println("消费10元，余额："+money.getReference()+"元");
                                break;
                            }
                        } else {
                            System.out.println("没有足够的金额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

//    public static void main(String[] args) {
//        money.set(19);
//
//        for (int i = 0; i < 3; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    while (true) {
//                        while (true) {
//                            Integer m = money.get();
//                            if (m < 20) {
//                                if (money.compareAndSet(m, m + 20)) {
//                                    System.out.println("余额小于20，充值成功，余额: " + money.get() + "元");
//                                    break;
//                                }
//                            } else {
//                                break;
//                            }
//                        }
//                    }
//                }
//            }.start();
//        }
//
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    while (true) {
//                        Integer m = money.get();
//                        if (m > 10) {
//                            System.out.println("大于10元");
//                            if (money.compareAndSet(m, m - 10)) {
//                                System.out.println("消费10元， 余额: " + money.get() + "元");
//                                break;
//                            }
//                        } else {
//                            break;
//                        }
//                    }
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//    }
}
