package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-04-28 16:08
 * @description: 692
 **/
public class SixNineTwo {

    public List<String> topKFrequent(String[] words, int k) {
        // calculate frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // build the buckets
        TrieNode[] count = new TrieNode[words.length + 1];
        for (String word : freqMap.keySet()) {
            int freq = freqMap.get(word);
            if (count[freq] == null) {
                count[freq] = new TrieNode();
            }
            addWord(count[freq], word);
        }

        // get k frequent words
        List<String> list = new LinkedList<>();
        for (int f = count.length - 1; f >= 1 && list.size() < k; f--) {
            if (count[f] == null) {
                continue;
            }
            getWords(count[f], list, k);
        }
        return list;
    }

    private void getWords(TrieNode node, List<String> list, int k) {
        if (node == null) {
            return;
        }
        if (node.word != null) {
            list.add(node.word);
        }
        if (list.size() == k) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                getWords(node.next[i], list, k);
            }
        }
    }

    private boolean addWord(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.word = word;
        return true;
    }

    class TrieNode {
        TrieNode[] next;
        String word;

        TrieNode() {
            this.next = new TrieNode[26];
            this.word = null;
        }
    }

    public static void main(String[] args) {
        SixNineTwo sixNineTwo = new SixNineTwo();
//        sixNineTwo.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        sixNineTwo.topKFrequent(new String[]{"i", "leetcode", "leetcode", "love", "coding", "mm", "mm"}, 2);
    }

    /**
     * heap
     * @param words
     * @param k
     * @return
     */
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> count = new HashMap<>();
//        // count words
//        for (String word: words) {
//            count.put(word, count.getOrDefault(word, 0) + 1);
//        }
//        PriorityQueue<String> heap = new PriorityQueue<>(
//                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
//                        w2.compareTo(w1) : count.get(w1) - count.get(w2)
//        );

//        for (String word : count.keySet()) {
//            heap.offer(word);
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }

//        List<String> ans = new ArrayList<>();
//        while (!heap.isEmpty()) {
//            ans.add(heap.poll());
//        }
//        Collections.reverse(ans);
//        return ans;
//
//    }

    /**
     * sort solution
     * @param words
     * @param k
     * @return
     */
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> count = new HashMap<>();
//        for (String word : words) {
//            count.put(word, count.getOrDefault(word, 0) + 1);
//        }
//        List<String> candidates = new ArrayList<>(count.keySet());
//        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(w2)
//                ? w1.compareTo(w2) : count.get(w2) - count.get(w1));
//        return candidates.subList(0, k);
//    }
}
