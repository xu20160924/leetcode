package com.john;

/**
 * @author: John
 * @date: 2020-03-18 18:52
 * @description: bits
 **/
public class Bits {

    public int swapOddEven(int n) {
        int even = n & n & 0xaaaaaaaa; // get even bits
        int odd = n & 0x55555555; // get odd bits
        return (even >> 1) ^ (odd << 1);
    }
}
