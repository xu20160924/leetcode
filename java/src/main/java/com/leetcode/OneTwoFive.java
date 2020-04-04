package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-14 18:32
 * @description: 125
 **/
public class OneTwoFive {
//    public boolean isPalindrome(String s) {
//        if (s.isEmpty()) {
//            return true;
//        }
//        int head = 0, tail = s.length() - 1;
//        char cHead, cTail;
//        while (head <= tail) {
//            cHead = s.charAt(head);
//            cTail = s.charAt(tail);
//            if (!Character.isLetterOrDigit(cHead)) {
//                head++;
//            } else if (!Character.isLetterOrDigit(cTail)) {
//                tail--;
//            } else {
//                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
//                    return false;
//                }
//                head++;
//                tail--;
//            }
//        }
//        return true;
//    }

    public boolean isPalindrome(String s) {
       char[] c = s.toCharArray();
       for (int i = 0, j = c.length - 1; i < j;) {
           if (!Character.isLetterOrDigit(c[i])) {
               i++;
           } else if (!Character.isLetterOrDigit(c[j])) {
               j--;
           } else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--])) {
               return false;
           }
       }
       return true;
    }
}
