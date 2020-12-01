package com.designpattern.chain;

import com.sun.tools.javac.util.AbstractLog;

/**
 * @author: John
 * @date: 2020-04-24 15:51
 * @description:
 **/
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "information");
        loggerChain.logMessage(AbstractLogger.DEBUG, "debug information");
        loggerChain.logMessage(AbstractLogger.ERROR, "error information");
    }

}
