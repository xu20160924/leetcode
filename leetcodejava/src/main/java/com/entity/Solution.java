package com.entity;

import java.sql.SQLOutput;
import java.util.*;

class Solution {
    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) {
            return new ArrayList<>();
        }

        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            root.insert(words[i]);
        }

        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dfs(board, visited, root, i, j, "");
            }
        }
        return new ArrayList<>(result);

    }

    public void dfs(char[][] board, boolean[][] visited, Trie node, int x, int y, String curs) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        curs += board[x][y];
        if (!node.searchWith(curs)) {
            return;
        }

        if (node.search(curs)) {
            result.add(curs);
        }
        visited[x][y] = true;

        dfs(board, visited, node, x - 1, y, curs);
        dfs(board, visited, node, x + 1, y, curs);
        dfs(board, visited, node, x, y - 1, curs);
        dfs(board, visited, node, x, y + 1, curs);
        visited[x][y] = false;

    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        public TrieNode searchPrefix(String s) {
            TrieNode node = root;
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (node.containKey(currentChar)) {
                    node = node.get(currentChar);
                } else {
                    return null;
                }
            }
            return node;
        }

        public boolean search(String s) {
            TrieNode node = searchPrefix(s);
            return node != null && node.isEnd();
        }

        public boolean searchWith(String s) {
            TrieNode node = searchPrefix(s);
            return node != null;
        }

    }


    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        TrieNode() {
            links = new TrieNode[R];
        }

        public void put(char s, TrieNode trieNode) {
            links[s - 'a'] = trieNode;
        }

        public boolean containKey(char s) {
            return links[s - 'a'] != null;
        }

        public TrieNode get(char s) {
            return links[s - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

//    public static int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        int i = 0, b = 1;
//        while (b <= num) {
//            while (i < b && i + b <= num) {
//                ans[i + b] = ans[i] + 1;
//                ++i;
//            }
//            i = 0;
//            b <<= 1;
//        }
//        return ans;
//    }


//    public static int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        for (int i = 1; i <= num; ++i) {
//            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
//        }
//        return ans;
//    }

    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i < ans.length; i++) {
            System.out.println("i:" + i);
            System.out.println("i & (i - 1):" + Integer.toBinaryString(i & (i - 1)));
            System.out.println("ans[i & (i - 1)]:" + ans[i & (i - 1)]);
            System.out.println("i & (i - 1) + 1:" + Integer.toBinaryString(ans[i & (i - 1)] + 1));
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
//        System.out.println((6 & (6 - 1))  + 1);
//        System.out.println(countBits(5));
        System.out.println( Integer.toBinaryString(6 & (6 - 1)));
        //        System.out.println(Integer.toBinaryStr
        //        ing(302 & (302 -1)));
//        int b = 1;
//        System.out.println(b <<= 1);
//        Arrays.asList().forEach(x -> System.out.println(x));
//        int[] result = countBits(605);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//        char[][] board = new {["o", "a", "a", "n"],["e", "t", "a", "e"],["i", "h", "k", "r"],["i", "f", "l", "v"]]
//["oath", "pea", "eat", "rain"]};
//        ["o", "a", "a", "n"],["e", "t", "a", "e"],["i", "h", "k", "r"],["i", "f", "l", "v"]]
//["oath", "pea", "eat", "rain"]
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e','t','a','e'},
//                {'i', 'h', 'k', 'r'},
//                {'i','f','l','v'}};
//        String[] words = {"oath", "pea", "eat", "rain"};
//        char[][] board = {{'a', 'a'}};
//        String[] words = {"a"};
//        Solution solution = new Solution();
//        System.out.println(solution.findWords(board, words));
    }
}