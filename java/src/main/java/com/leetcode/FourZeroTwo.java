package com.leetcode;

/**
 * @author: John
 * @date: 2020-04-17 17:29
 * @description: 402
 **/
public class FourZeroTwo {
//    public String removeKdigits(String num, int k) {
//        String numNew = num;
//        for (int i = 0; i < k; i++) {
//            boolean hasCut = false;
//            // 从左向右遍历，找到比自己右侧数字大的数字并删除
//            for (int j = 0; j < numNew.length() - 1; j++) {
//                if (numNew.charAt(j) > numNew.charAt(j + 1)) {
//                    numNew = numNew.substring(0, j) + numNew.substring(j + 1, numNew.length());
//                    hasCut = true;
//                    break;
//                }
//            }
//            // 如果没有找到要删除的数字，则删除最后一个数字
//            if (!hasCut) {
//                numNew = numNew.substring(0, numNew.length() - 1);
//            }
//            // 清除整数左侧的数字0
//            numNew = removeZero(numNew);
//        }
//
//        // 如果整数的所有数字都被删除了， 直接返回0
//        if (numNew.length() == 0) {
//            return "0";
//        }
//        return numNew;
//    }
//
//    private String removeZero(String num) {
//       for (int i = 0; i < num.length() - 1; i++) {
//           if (num.charAt(0) !=  '0') {
//               break;
//           }
//           num = num.substring(1, num.length());
//       }
//       return num;
//    }


//    public String removeKdigits(String num, int k) {
//        int len = num.length();
//        // corner case
//        if (k == len) {
//            return "0";
//        }
//        Stack<Character> stack = new Stack<>();
//        int i = 0;
//        while (i < num.length()) {
//            // whenever meet a digit which is less than the previous digit,
//            // discard the previous one
//            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
//                stack.pop();
//                k--;
//            }
//            stack.push(num.charAt(i));
//            i++;
//        }
//
//        // corner case like "111"
//        while (k > 0) {
//           stack.pop();
//           k--;
//        }
//
//        // construct the number from the stack
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        sb.reverse();
//
//        // remove all the 0 at the head
//        while (sb.length() > 1 && sb.charAt(0) == '0') {
//            sb.deleteCharAt(0);
//        }
//        return sb.toString();
//    }

//    public String removeKdigits(String num, int k) {
//        int newLength = num.length() - k;
//        char[] stack = new char[num.length()];
//        int top = 0;
//        for (int i = 0; i < num.length(); ++i) {
//            char c = num.charAt(i);
//            while (top > 0 && stack[top - 1] > c && k > 0) {
//                top--;
//                k--;
//            }
//            stack[top++] = c;
//        }
//        int offset = 0;
//        while (offset < newLength && stack[offset] == '0') {
//            offset++;
//        }
//        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
//    }

//    public String removeKdigits(String num, int k) {
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < num.length(); i++) {
//            if (i == num.length() - 1 && k == 0) {
//                str.append(num.charAt(i));
//                return str.toString();
//            }
//            if (k > 0 && num.charAt(i) <= num.charAt(i + 1) && (num.charAt(i) != '0' && str.length() == 0)) {
//                k--;
//                str.append(num.charAt(i));
//            }
//        }
//        return str.toString();
////        StringBuilder str = new StringBuilder(num);
////        for (int i = 0; i < num.length() - 1; i++) {
////            if (k > 0 && (num.charAt(i) > num.charAt(i + 1) || num.charAt(i) == '0')) {
////                str.deleteCharAt(i);
////            }
////        }
//    }

    public String removeKdigits(String num, int k) {
       if (num.length() == k) {
          return "0";
       }
       StringBuilder s = new StringBuilder(num);
       for (int i = 0; i < k; i++) {
           int idx = 0;
           // 本是应该找比后面大的字符， 但是这里反过来处理 只要比上一个大就往后走；
           // 然后找到第一个不比上一个大的，也就是第一个比后面大的
           for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) {
                idx = j;
           }
           s.delete(idx, idx + 1);
           while (s.length() > 1 && s.charAt(0) == '0') {
               s.delete(0, 1);
           }
       }
       return s.toString();
    }

    public static void main(String[] args) {
        String a = "10";
//        System.out.println(Integer.parseInt(a));
        FourZeroTwo fourZeroTwo = new FourZeroTwo();
//        System.out.println(fourZeroTwo.removeKdigits(a, ));
    }
}
