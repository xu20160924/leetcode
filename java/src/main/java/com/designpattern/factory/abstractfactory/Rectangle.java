package com.designpattern.factory.abstractfactory;

import com.designpattern.factory.abstractfactory.Shape;

/**
 * @author: John
 * @date: 2020-04-24 14:31
 * @description: Abstract Factory
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(".....");
    }
}
