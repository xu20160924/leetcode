package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-02 21:43
 * @description: 380
 **/
public class ThreeEightZero {

    private Map<Integer, Integer> dict;
    private List<Integer> list;
    Random rand = new Random();

    public ThreeEightZero() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);

        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
    }

}
