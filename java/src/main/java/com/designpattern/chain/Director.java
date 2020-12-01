package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:22
 * @description:
 **/
public class Director extends Leader {
    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(MoneyRequest moneyRequest) {
        if (moneyRequest.getMoney() < 300) {
            System.out.println("...");
        } else {
            this.successor.handleRequest(moneyRequest);
        }
    }
}
