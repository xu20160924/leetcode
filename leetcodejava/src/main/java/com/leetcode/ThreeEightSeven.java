package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-01-21 17:46
 * @description: 387
 **/
public class ThreeEightSeven {
//    public int firstUniqChar_1(String s) {
//        Map<Character, Integer> map = new HashMap<>(26);
//        char[] chars = s.toCharArray();
//        for (char ch : chars) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (map.get(chars[i]) == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public int firstUniqChar_2(String s) {
//        int[] freq = new int[26];
//        char[] chars = s.toCharArray();
//        for (char ch : chars) {
//            freq[ch - 'a']++;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (freq[chars[i] - 'a'] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public int firstUniqChar_3(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public int firstUniqChar_4(String s) {
//        boolean[] notUniq = new boolean[26];
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (!notUniq[ch -'a']) {
//                if (s.indexOf(ch) == s.lastIndexOf(ch)) {
//                    return i;
//                } else {
//                    notUniq[ch - 'a'] = true;
//                }
//            }
//        }
//        return -1;
//    }

//    public int firstUniqChar(String s) {
//        int res = -1;
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            int index = s.indexOf(ch);
//            if (index != -1 && index == s.lastIndexOf(ch)) {
//                res = (res == -1 || res > index) ? index : res;
//            }
//        }
//        return res;
//    }


//    public static int firstUnqieChar(String s) {
//        HashMap<Character, Integer> count = new HashMap<>();
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//           char c = s.charAt(i);
//           count.put(c, count.getOrDefault(c, 0) + 1);
//        }
//
//        for (int i = 0; i < n; i++) {
//           if (count.get(s.charAt(i)) == 1) {
//               return i;
//           }
//        }
//        return -1;
//    }

//    public int firstUniqChar(String s) {
//        if (s == null || s.equals("")) {
//            return -1;
//        }
//        if (s.length() == 1) {
//            return 0;
//        }
//        int idx = 0;
//        long mark = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int num = 1 << (s.charAt(i) - 'a');
//            if ((mark & num) != 0) {
//                idx--;
//                // return i - 2;
//            } else {
//                mark |= num;
//                idx++;
//            }
//        }
//        // if (s.length() == 2) {
//        //     return 0;
//        // }
//        return idx;
//    }

//    public int firstUniqChar(String s) {
//       HashMap<Character, Integer> count = new HashMap<>();
//       int n = s.length();
//
//       for (int i = 0; i < n; i++) {
//           char c = s.charAt(i);
//           count.put(c, count.getOrDefault(c, 0) + 1);
//       }
//       for (int i = 0; i < n; i++) {
//           if (count.get(s.charAt(i)) == 1) {
//               return i;
//           }
//       }
//       return -1;
//    }

//    public int firstUniqChar(String s) {
//       int[] freq = new int[26];
//       for (int i = 0; i < s.length(); i++) {
//           freq[s.charAt(i) - 'a']++;
//       }
//       for (int i = 0; i < s.length(); i++) {
//           if (freq[s.charAt(i) - 'a'] == 1) {
//               return i;
//           }
//       }
//       return -1;
//    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }
        return map.size() == 0 ? - 1 : map.entrySet().iterator().next().getValue();
    }

    public static void main(String[] args) {
        ThreeEightSeven t = new ThreeEightSeven();
        t.firstUniqChar("leetcode");
    }
}
