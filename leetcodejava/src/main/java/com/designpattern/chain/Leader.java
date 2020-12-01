package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:21
 * @description:
 **/
public abstract class Leader {

    protected String name;
    protected Leader successor;

    public Leader(String name) {
        this.name = name;
    }

    public void setSuccessor(Leader successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(MoneyRequest moneyRequest);
}
