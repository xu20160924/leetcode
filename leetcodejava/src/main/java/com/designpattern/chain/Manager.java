package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:26
 * @description:
 **/
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(MoneyRequest moneyRequest) {
        if (moneyRequest.getMoney() < 800) {
            System.out.println("...");
        } else {
            this.successor.handleRequest(moneyRequest);
        }
    }
}
