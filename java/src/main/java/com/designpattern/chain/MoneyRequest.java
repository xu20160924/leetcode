package com.designpattern.chain;

/**
 * @author: John
 * @date: 2020-04-24 15:20
 * @description:
 **/
public class MoneyRequest {
    private String name;
    private double money;

    public MoneyRequest(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
