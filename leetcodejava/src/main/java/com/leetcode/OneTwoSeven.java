package com.leetcode;

import java.util.*;
import com.entity.Pair;

/**
 * @author: John
 * @date: 2020-03-29 17:15
 * @description: 127
 **/
public class OneTwoSeven {

    private int L;
    private Map<String, List<String>> allComboDict;

    OneTwoSeven() {
        this.L = 0;
        // Dictionary to hold combination of words that can be formed.
        // from any given word. By changing one letter at a time.
        this.allComboDict = new HashMap<>();
    }

    private int visitWordNode(
      Queue<Pair<String, Integer>> Q,
      Map<String, Integer> visited,
      Map<String, Integer> otherVisited
    ) {
        Pair<String, Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < this.L; i++) {
            // Intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i+1, this.L);

            // Next states are all the words which sahre the same Intermediate state.
            for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                // If at any point if we find what we are looking for
                // i.e. the end word - we can return with theanswer.
                if (otherVisited.containsKey(adjacentWord)) {
                    return level + otherVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {
                    // Save the level as the value of the Dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Since all words are of same length.
        this.L = beginWord.length();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = this.allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(newWord);
                        this.allComboDict.put(newWord, transformations);
                    }
                }
        );

        // Queues for birdirectional BFS
        // BFS starting from beginWord
        Queue<Pair<String, Integer>> Qbegin = new LinkedList<>();
        // BFS starting from endWord
        Queue<Pair<String, Integer>> Qend = new LinkedList<>();
        Qbegin.add(new Pair<>(beginWord, 1));
        Qend.add(new Pair<>(endWord, 1));

        // Visisted to make sure we dont repeat processsing same word.
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!Qbegin.isEmpty() && !Qend.isEmpty()) {
            // one hop from begin word
            int ans = visitWordNode(Qbegin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }
            // one hop from end word
            ans = visitWordNode(Qend, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }
        return 0;
    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        // Since all words are of same length.
//        int L = beginWord.length();
//
//        // Dictionary to hold combination of words that can be formed,
//        // from any given word. By changing one letter at a time.
//        Map<String, List<String>> allComboDict = new HashMap<>();
//
//        wordList.forEach(
//                word -> {
//                    for (int i = 0; i < L; i++) {
//                        // Key is the generic word
//                        // Value is a list of words which have the same intermediate generic word.
//                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
//                        transformations.add(word);
//                        allComboDict.put(newWord, transformations);
//                    }
//                }
//        );
//
//        // Queue for BFS
//        Queue<Pair<String, Integer>> Q = new LinkedList<>();
//        Q.add(new Pair<>(beginWord, 1));
//
//        // visited to make sure we dont repeat processing same word.
//        Map<String, Boolean> visited = new HashMap<>();
//        visited.put(beginWord, true);
//
//        while (!Q.isEmpty()) {
//            Pair<String, Integer> node = Q.remove();
//            String word = node.getKey();
//            int level = node.getValue();
//            for (int i = 0; i < L; i++) {
//                // Intermediate words for current word
//                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//
//                // Next states are all the words which share the same intermediate state.
//                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
//                    // If at any point if we find what we are looking for
//                    // the end word - we can return with the answer.
//                    if (adjacentWord.equals(endWord)) {
//                        return level + 1;
//                    }
//                    // Otherwise, add it to the BFS Queue. Also mark it visited
//                    if (!visited.containsKey(adjacentWord)) {
//                        visited.put(adjacentWord, true);
//                        /**
//                         * 这道题之所以使用双向可以进一步优化是因为单向的bfs 会不断的向queue中添加下一步的word,
//                         * 如果每次都添加多个word 这样再进行下一次的循环时就要匹配更多的word以至于膨胀；
//                         * 而双向bfs会减少这个单个bfs的深度来减少最大膨胀值
//                         */
//                        Q.add(new Pair<>(adjacentWord, level + 1));
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        OneTwoSeven oneTwoSeven = new OneTwoSeven();
        oneTwoSeven.ladderLength("hit", "cog", wordList);
    }
}
