package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:46
 * @description:
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("...");
    }
}
