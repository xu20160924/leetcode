package com.john;

/**
 * @author: John
 * @date: 2020-10-23 15:23
 * @description:
 **/
public class FinalReferenceEscapeDemo {
    private final int a;
    private FinalReferenceEscapeDemo referenceEscapeDemo;

    public FinalReferenceEscapeDemo() {
        a = 1;  // 1
        referenceEscapeDemo = this; // 2
    }
    public void writer() {
        new FinalReferenceEscapeDemo();
    }
    public void reader() {
        if (referenceEscapeDemo  != null) { // 3
            int temp = referenceEscapeDemo.a; // 4
        }
    }
}
