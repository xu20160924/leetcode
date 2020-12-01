package com.lintcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-04-22 12:15
 * @description: 171
 **/
public class OneSevenOne {
//    /**
//     * base sort
//     * 将所有字符串排序后进行比较
//     * @param strs
//     * @return
//     */
//    public List<String> anagrams(String[] strs) {
//        List<String> result = new ArrayList<>();
//        if (strs == null || strs.length == 0) {
//            return result;
//        }
//
//        Map<String, ArrayList<String>> map = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            char[] arr = strs[i].toCharArray();
//            Arrays.sort(arr);
//            // 排序后的string 作为key
//            String s = String.valueOf(arr);
//            if (!map.containsKey(s)) {
//                ArrayList<String> list = new ArrayList<>();
//                map.put(s, list);
//            }
//            map.get(s).add(strs[i]);
//        }
//
//        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
//            if (entry.getValue().size() >= 2) {
//                result.addAll(entry.getValue());
//            }
//        }
//        return result;
//    }

    private int getHash(int[] count) {
        int hash =  0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
           hash = hash * a + num;
           a = a * b;
        }
        return hash;
    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
           int[] count = new int[26];
           for (int i = 0; i < str.length(); i++) {
               count[str.charAt(i) - 'a']++;
           }

           int hash = getHash(count);
           if (!map.containsKey(hash)) {
               map.put(hash, new ArrayList<>());
           }
           map.get(hash).add(str);
        }

        for (ArrayList<String> list : map.values()) {
            if (list.size() > 1) {
               result.addAll(list);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        OneSevenOne oneSevenOne = new OneSevenOne();
        oneSevenOne.anagrams(new String[]{"lint", "intl", "inlt", "code"});
    }
}
