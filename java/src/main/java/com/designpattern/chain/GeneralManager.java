package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:25
 * @description:
 **/
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(MoneyRequest moneyRequest) {
        if (moneyRequest.getMoney() < 2000) {
            System.out.println("...");
        } else {
            System.out.println("...");
        }
    }
}
