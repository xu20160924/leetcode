package com.john;

/**
 * @author: John
 * @date: 2020-01-20 11:38
 * @description: JavaLabel
 **/
public class Label {

//    public static void main(String[] args) {
//        boolean t = true;
//        first: {
//            second: {
//                thrid: {
//                    System.out.println("Before the break");
//                    if (t) {
//                        break second;
//                    }
//                    System.out.println("This won't execute");
//                }
//                System.out.println("This is after the second block");
//            }
//        }
//    }

    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            System.out.println("Pass" + i + ": ");
            for (int j = 0; j < 100; j++) {
                if (j == 10) {
                    break outer; // Exit both loops
                }
                System.out.println(j + " ");
            }
            System.out.println("This will not be printed");
        }
        System.out.println("Loops complete.");
    }

}
