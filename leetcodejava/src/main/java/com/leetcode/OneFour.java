package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-06 09:48
 * @description: 14
 **/
public class OneFour {

    // Horizontal scanning
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) {
//                    return "";
//                }
//            }
//        }
//        return prefix;
//    }

    // vertical scanning
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        for (int i = 0; i < strs[0].length(); i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];
//    }


    // Divide and conquer
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        return longestCommonPrefix(strs, 0, strs.length - 1);
//    }
//
//    private String longestCommonPrefix(String[] strs, int l, int r) {
//        if (l == r) {
//           return strs[l];
//        } else {
//            int mid = (l + r) / 2;
//            String lcpLeft = longestCommonPrefix(strs, l, mid);
//            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
//            return commonPrefix(lcpLeft, lcpRight);
//        }
//    }
//
//    String commonPrefix(String left, String right) {
//        int min = Math.min(left.length(), right.length());
//        for (int i = 0; i < min; i++) {
//            if (left.charAt(i) != right.charAt(i)) {
//               return left.substring(0, i);
//            }
//        }
//        return left.substring(0, min);
//    }


//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        int minLen = Integer.MAX_VALUE;
//        for (String str : strs) {
//            minLen = Math.min(minLen, str.length());
//        }
//        int low = 1;
//        int high = minLen;
//        while (low <= high) {
//            int middle = (low + high) / 2;
//            if (isCommonPrefix(strs, middle)) {
//                low = middle + 1;
//            } else {
//                high = middle - 1;
//            }
//        }
//        return strs[0].substring(0, (low + high) / 2);
//    }
//
//    private boolean isCommonPrefix(String[] strs, int len) {
//        String str1 = strs[0].substring(0, len);
//        for (int i = 1; i < strs.length; i++) {
//            if (!strs[i].startsWith(str1)) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        String pre = strs[0];
//        int i = 1;
//        while (i < strs.length) {
//            while (strs[i].indexOf(pre) != 0) {
//                pre = pre.substring(0, pre.length() - 1);
//            }
//            i++;
//        }
//        return pre;
//    }

//    public String longestCommonPrefix(String[] strs) {
//       if (strs.length == 0) {
//           return "";
//       }
//       String pre = strs[0];
//       for (int i = 1; i < strs.length; i++) {
//           while (strs[i].indexOf(pre) != 0) {
//               pre = pre.substring(0, pre.length() - 1);
//           }
//       }
//       return pre;
//    }


    /**
     * flower
     * flow
     * flight
     * @param strs
     * @return
     */
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) {
//                    return "";
//                }
//            }
//        }
//       return prefix;
//
//    }


//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        for (int i = 0; i < strs[0].length(); i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];
//    }


    /**
     *  divide and conquer
     * @param strs
     * @return
     */
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        return longestCommonPrefix(strs, 0, strs.length - 1);
//    }
//
//    private String longestCommonPrefix(String[] strs, int l, int r) {
//        if (l == r) {
//            return strs[l];
//        } else {
//            int mid = (l + r) / 2;
//            String lcpLeft = longestCommonPrefix(strs, l, mid);
//            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
//            return commonPrefix(lcpLeft, lcpRight);
//        }
//    }
//
//    private String commonPrefix(String left, String right) {
//        int min = Math.min(left.length(), right.length());
//        for (int i = 0; i < min; i++) {
//            if (left.charAt(i) != right.charAt(i)) {
//                return left.substring(0, i);
//            }
//        }
//        return left.substring(0, min);
//    }




    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        OneFour oneFour = new OneFour();
        oneFour.longestCommonPrefix(strs);
    }
}