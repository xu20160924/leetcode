package com.designpattern.factory.simplefactory;

/**
 * @author: John
 * @date: 2020-04-24 14:09
 * @description: Factory pattern
 **/
public class Factory {
    /**
     * 简单工厂
     * @param senderType
     * @return
     */
    public Sender produceSender(String senderType) {
        if (senderType == null) {
            return null;
        } else if (senderType.equals("sms")) {
            return new SMSSender();
        } else if (senderType.equals("email")) {
            return new EmailSender();
        } else {
            System.out.println("invalid senderType");
            return null;
        }
    }

    // 工厂方法模式 不需要实例化工厂, 可以直接调用创建实例
//    public static Sender produceEmail() {
//        return new EmailSender();
//    }
//
//    public static Sender produceSMS() {
//        return new SMSSender();
//    }



    // 具体的工厂接口实现类, 实现统一的产品接口
    class EmailSender implements Sender {

        @Override
        public void send() {
            System.out.println("sending.....");
        }
    }

    class SMSSender implements Sender {
        @Override
        public void send() {
            System.out.println("sending.....");
        }
    }
}
