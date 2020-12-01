package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-01-20 16:00
 * @description:
 **/
class Solution {

//    Set<String> res = new HashSet<String>();
//
//    public List<String> findWords(char[][] board, String[] words) {
//        Trie trie = new Trie();
//
//        for (String word : words) {
//            trie.insert(word);
//        }
//
//        int m = board.length;
//        int n = board[0].length;
//        boolean[][] visited = new boolean[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dfs(board, visited, i, j, "", trie);
//            }
//        }
//        return new ArrayList<>(res);
//
//    }
//
//    private void dfs(char[][] board, boolean[][] visited, int x, int y, String s, Trie trie) {
//        if (x < 0 || x >= board.length || y <0 || y >= board[0].length) {
//            return;
//        }
//        if (visited[x][y]) {
//            return;
//        }
//        s += board[x][y];
//        if(!trie.searchStartsWith(s)) {
//            return;
//        }
//
//        if (trie.search(s)) {
//            res.add(s);
//        }
//
//        visited[x][y] = true;
//        dfs(board, visited, x + 1, y, s, trie);
//        dfs(board, visited, x - 1, y, s, trie);
//        dfs(board, visited,  x, y -1 , s, trie);
//        dfs(board, visited, x, y + 1, s, trie);
//        visited[x][y] = false;
//
//    }
//
//
//    class Trie {
//        private TrieNode root;
//
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        public boolean search(String s) {
//            TrieNode node = searchPrefix(s);
//            return node != null && node.isEnd();
//        }
//
//        public TrieNode searchPrefix(String s) {
//            TrieNode node = root;
//            for (int i = 0; i < s.length(); i++) {
//                char cur = s.charAt(i);
//                if (node.containsKey(cur)) {
//                    node = node.get(cur);
//                } else {
//                    return null;
//                }
//            }
//            return node;
//        }
//
//        public boolean searchStartsWith(String s) {
//            return searchPrefix(s) != null;
//        }
//
//        public void insert(String s) {
//            TrieNode node = root;
//            for(int i = 0; i < s.length(); i++) {
//                char ch =s.charAt(i);
//                if (!node.containsKey(ch)) {
//                    node.put(ch, new TrieNode());
//                }
//                node = node.get(ch);
//            }
//            node.setEnd();
//        }
//        class TrieNode {
//            private TrieNode[] links;
//            private final int R = 26;
//            private boolean isEnd;
//
//            public TrieNode() {
//                links = new TrieNode[R];
//            }
//            public boolean containsKey(char ch) {
//                return links[ch - 'a'] != null;
//            }
//            public TrieNode get(char ch) {
//                return links[ch - 'a'];
//            }
//            public void put(char ch, TrieNode node) {
//               links[ch - 'a'] = node;
//            }
//            public void setEnd() {
//               this.isEnd = true;
//            }
//            public boolean isEnd() {
//                return this.isEnd;
//            }
//        }
//    }




    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        public TrieNode() {
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
}