package com.designpattern.factory.abstractfactory;

/**
 * @author: John
 * @date: 2020-04-24 14:37
 * @description: 抽象工厂
 **/
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
