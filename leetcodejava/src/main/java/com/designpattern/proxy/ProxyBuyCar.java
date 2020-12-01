package com.designpattern.proxy;

/**
 * @author: John
 * @date: 2020-04-24 14:59
 * @description:
 **/
public class ProxyBuyCar implements BuyCar {

    private People people;

    @Override
    public void buycar() {
        if (people.getVip().equals("vip")) {
            people.buycar();
        } else if (people.getCash() >= 50000) {
            System.out.println("...");
        } else {
            System.out.println("...");
        }
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
