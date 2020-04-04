package com.lintcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-27 12:40
 * @description: 127
 **/
public class OneTwoSeven {
    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int label) {
            this.label = label;
            neighbors = new ArrayList<>();
        }
    }

//    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
//        ArrayList<DirectedGraphNode> order = new ArrayList<>();
//        if (graph == null) {
//            return order;
//        }
//
//        //1. count indegree
//        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
//
//        //2. topological sorting bfs
//        ArrayList<DirectedGraphNode> startNodes = getStartNodes(indegree, graph);
//
//        //3. bfs
//        order = bfs(indegree, startNodes);
//
//        if (order.size() == graph.size()) {
//            return order;
//        }
//        return null;
//    }
//
//    private ArrayList<DirectedGraphNode> bfs(ArrayList<DirectedGraphNode> nodes) {
//        ArrayList<DirectedGraphNode> order = new ArrayList<>();
//        Queue<DirectedGraphNode> queue = new LinkedList<>();
//        for (DirectedGraphNode node : nodes) {
//
//        }
//    }
//
//    private Map<DirectedGraphNode, Integer> getIndegree(List<DirectedGraphNode> graph) {
//
//    }
//
//    private ArrayList<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> indegree, List<DirectedGraphNode> graph) {
//        ArrayList<DirectedGraphNode> nodes = new ArrayList<>();
//        for (DirectedGraphNode node : graph) {
//            if (indegree.get(node) == 0) {
//                nodes.add(node);
//            }
//        }
//        return nodes;
//    }

//    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
//        ArrayList<DirectedGraphNode> result = new ArrayList<>();
//        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
//        for (DirectedGraphNode node : graph) {
//            for (DirectedGraphNode neighbor : node.neighbors) {
//                if (map.containsKey(neighbor)) {
//                    map.put(neighbor, map.get(neighbor) + 1);
//                } else {
//                    map.put(neighbor, 1);
//                }
//            }
//        }
//        Queue<DirectedGraphNode> queue = new LinkedList<>();
//        for (DirectedGraphNode node : graph) {
//            if (!map.containsKey(node)) {
//                queue.offer(node);
//                result.add(node);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            DirectedGraphNode node = queue.poll();
//            for (DirectedGraphNode n : node.neighbors) {
//                map.put(n, map.get(n) - 1);
//                if (map.get(n) == 0) {
//                   result.add(n);
//                   queue.offer(n);
//                }
//            }
//        }
//        return result;
//    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }

//        wordList.add();

        HashSet<String> hash = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        hash.add(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, wordList)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private ArrayList<String> getNextWords(String word, List<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a';  c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
               if (c == word.charAt(i)) {
                  continue;
               }
               String nextWord = replace(word, i, c);
               if (dict.contains(nextWord)) {
                   nextWords.add(nextWord);
               }
            }
        }
        return nextWords;
    }

}
