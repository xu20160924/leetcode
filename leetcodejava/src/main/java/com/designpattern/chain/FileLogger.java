package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:50
 * @description:
 **/
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("...");
    }
}
