package com.leetcode;



import com.entity.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-01-22 22:36
 * @description: 76
 **/
public class SevenSix {


//    public static String minWindow(String s, String t) {

//        if (s.length() == 0 || t.length() == 0) {
//            return "";
//        }

//        // Dictionary which keeps a count of all the unique characters in t.
//        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
//        for (int i = 0; i < t.length(); i++) {
//            int count = dictT.getOrDefault(t.charAt(i), 0);
//            dictT.put(t.charAt(i), count + 1);
//        }

//        // Number of unique characters in t, which need to be present in the desired window.
//        int required = dictT.size();

//        // Left and Right pointer
//        int l = 0, r = 0;

//        // formed is used to keep track of how many unique characters in t
//        // are present in the current window in its desired frequency.
//        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
//        // Thus formed would be = 3 when all these conditions are met.
//        int formed = 0;

//        // Dictionary which keeps a count of all the unique characters in the current window.
//        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

//        // ans list of the form (window length, left, right)
//        int[] ans = {-1, 0, 0};

//        while (r < s.length()) {
//            // Add one character from the right to the window
//            char c = s.charAt(r);
//            int count = windowCounts.getOrDefault(c, 0);
//            windowCounts.put(c, count + 1);

//            // If the frequency of the current character added equals to the
//            // desired count in t then increment the formed count by 1.
//            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
//                formed++;
//            }

//            // Try and co***act the window till the point where it ceases to be 'desirable'.
//            while (l <= r && formed == required) {
//                c = s.charAt(l);
//                // Save the smallest window until now.
//                if (ans[0] == -1 || r - l + 1 < ans[0]) {
//                    ans[0] = r - l + 1;
//                    ans[1] = l;
//                    ans[2] = r;
//                }

//                // The character at the position pointed by the
//                // `Left` pointer is no longer a part of the window.
//                windowCounts.put(c, windowCounts.get(c) - 1);
//                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
//                    formed--;
//                }

//                // Move the left pointer ahead, this would help to look for a new window.
//                l++;
//            }

//            // Keep expanding the window once we are done co***acting.
//            r++;
//        }

//        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//    }

    /**
     * after optimiz
      * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }
        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering citeria is that the character should be present in t.
        List<Pair<Integer, Character>> fiilteredS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                fiilteredS.add(new Pair<Integer, Character>(i, c));
            }
        }
        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hench，we follow the sliding window approach on as small list.
        while (r < fiilteredS.size()) {
            char c = fiilteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            // Try and ** the window till the point where it caeses to be desirable
           while (l <= r && formed == required) {
                c = fiilteredS.get(l).getValue();
                // Save the smallest window until now
                int end = fiilteredS.get(r).getKey();
                int start = fiilteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
           }
           r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[l], ans[2] + 1);
    }



    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        System.out.println(SevenSix.minWindow(s, t));
        Integer i = new Integer(100);
        Integer j = new Integer(300);
        System.out.println(i > j);
    }
}
