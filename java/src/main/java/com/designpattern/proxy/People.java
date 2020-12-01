package com.designpattern.proxy;

/**
 * @author: John
 * @date: 2020-04-24 14:55
 * @description:
 **/
public class People implements BuyCar{

    private int cash;
    private String vip;
    private String username;

    @Override
    public void buycar() {
        System.out.println("...");
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
