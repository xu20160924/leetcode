package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:44
 * @description:
 **/
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("...");
    }
}
