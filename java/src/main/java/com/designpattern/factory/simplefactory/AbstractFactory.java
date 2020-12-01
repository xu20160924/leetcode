package com.designpattern.factory.simplefactory;

/**
 * @author: John
 * @date: 2020-04-24 14:24
 * @description: 接口工厂
 **/
public class AbstractFactory {

    class EmailFactory implements Producer {

        @Override
        public Sender provide() {
            return new EmailSender();
        }
    }

    class SMSFactory implements Producer {

        @Override
        public Sender provide() {
            return new SMSSender();
        }
    }


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
