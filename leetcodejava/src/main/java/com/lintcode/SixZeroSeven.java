package com.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-04-15 18:29
 * @description: 607
 **/
public class SixZeroSeven {

    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;

    public SixZeroSeven() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    // Add the number to an internal data structure
    public void add(int number) {
        // write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    // Find if there exists any pair of numbers
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
           int num1 = list.get(i), num2 = value - num1;
           if ((num1 == num2 && map.get(num1) > 1) ||
                   (num1 != num2 && map.containsKey(num2))) {
               return true;
           }
        }
        return false;
    }

}
