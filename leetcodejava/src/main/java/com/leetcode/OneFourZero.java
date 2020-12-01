package com.leetcode;


import java.util.*;

/**
 * @author: John
 * @date: 2020-09-21 20:11
 * @description: 140
 **/
public class OneFourZero {

//    public List<String> wordBreak(String s, Set<String> wordDict) {
//        return helper(s, wordDict, 0);
//    }

//    private List<String> helper(String s, Set<String> wordDict, int start) {
//        LinkedList<String> res = new LinkedList<>();
//        if (start == s.length()) {
//            res.add("");
//        }
//
//        for (int end = start + 1; end <= s.length(); end++) {
//            if (wordDict.contains(s.substring(start, end))) {
//                List<String> list = helper(s, wordDict, end);
//                for (String l : list) {
//                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
//                }
//            }
//        }
//        return res;
//    }

//    HashMap<Integer, List<String>> map = new HashMap<>();
//
//    public List<String> helper(String s, Set<String> wordDict, int start) {
//        if (map.containsKey(start)) {
//            return map.get(start);
//        }
//        LinkedList<String> res = new LinkedList<>();
//        if (start == s.length()) {
//            res.add("");
//        }
//        for (int end = start + 1; end <= s.length(); end++) {
//            if (wordDict.contains(s.substring(start, end))) {
//               List<String> list = helper(s, wordDict, end);
//               for (String l : list) {
//                   res.add(s.substring(start, end) + (l.equals("") ? "" : " " + l));
//               }
//            }
//        }
//        map.put(start, res);
//        return res;
//    }


//    public List<String> wordBreak(String s, Set<String> wordDict) {
//       return helper(s, wordDict, 0);
//    }

//    public List<String> wordBreak(String s, Set<String> wordDict) {
//        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
//        LinkedList<String> initial = new LinkedList<>();
//        initial.add("");
//        dp[0] = initial;
//        for (int i = 1; i <= s.length(); i++) {
//            LinkedList<String> list = new LinkedList<>();
//            for (int j = 0; j < i; j++) {
//                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
//                    for (String l : dp[j]) {
//                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
//                    }
//                }
//            }
//            dp[i] = list;
//        }
//        return dp[s.length()];
//    }

//    HashMap<Integer, List<String>> map = new HashMap<>();
//    private List<String> helper(String s, Set<String> wordDict, int start) {
//        if (map.containsKey(start)) {
//            return map.get(start);
//        }
//        LinkedList<String> res = new LinkedList<>();
//        if (start == s.length()) {
//            res.add("");
//        }
//        for (int end = start + 1; end <= s.length(); end++) {
//            if (wordDict.contains(s.substring(start, end))) {
//                List<String> list = helper(s, wordDict, end);
//                for (String l : list) {
//                   res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
//                }
//            }
//        }
//
//        map.put(start, res);
//        return res;
//    }

//    private List<String> helper(String s, Set<String> wordDict, int start) {
//        LinkedList<String> res = new LinkedList<>();
//        if (start == s.length()) {
//            res.add("");
//        }
//        for (int end = start + 1; end <= s.length(); end++) {
//            if (wordDict.contains(s.substring(start, end))) {
//                List<String> list = helper(s, wordDict, end);
//                for (String l : list) {
//                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
//                }
//            }
//        }
//        return res;
//    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordDictSet = new HashSet<>(wordDict);
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true;
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
//                   dp[i] = true;
//                   break;
//                }
//            }
//        }
//        return dp[s.length()];
//    }

//    public List<String> wordBreak(String s, Set<String> wordDict) {
//        return DFS(s, wordDict, new HashMap<>());
//    }
//
//    private List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
//        if (map.containsKey(s)) {
//            return map.get(s);
//        }
//        LinkedList<String> res = new LinkedList<>();
//        if (s.length() == 0) {
//            res.add("");
//            return res;
//        }
//        for (String word : wordDict) {
//            if (s.startsWith(word)) {
//                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
//                for (String sub : subList) {
//                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
//                }
//            }
//        }
//        map.put(s, res);
//        return res;
//    }


        HashMap<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (wordDict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(i), wordDict);
                for (String str : temp) {
                    res.add(str.equals("") ? "": " ");
                }
                //                if (temp.size() != 0) {
//                    for (String str : temp) {
//                        res.add(str + "")
//                    }
//                }

            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        OneFourZero oneFourZero = new OneFourZero();
        String s = "catsanddog";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        oneFourZero.wordBreak(s, wordDict);
    }

}
