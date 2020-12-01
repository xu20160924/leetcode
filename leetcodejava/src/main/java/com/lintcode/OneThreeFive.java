package com.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-04-01 13:09
 * @description: 135
 **/
public class OneThreeFive {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        Arrays.sort(candidates);
        recursion(candidates, 0, target, new ArrayList<>(), results);
        return results;
    }

    /**
     * 1. 递归的定义
     * 找到所有以combination开头的那些和为target的组合
     * 并丢到results里，其中剩余的需要加入combination里的数和为remainTarget
     * 并且下一个可以加入combnation中的数至少从candidates的startIndex开始
     */
    private void recursion(int[] candidates, int startIndex, int remainTarget,
                           List<Integer> combination,
                           List<List<Integer>> results) {
        // 负数判断
//        if (remainTarget < 0) {
//            return;
//        }

        // 3. 递归的出口
        if (remainTarget == 0) {
           results.add(new ArrayList<>(combination));
           return;
        }

        // 2. 递归的拆解
        for (int i = startIndex; i < candidates.length; i++) {
            // 这句负数判断也可以写在函数入口
            if (remainTarget < candidates[i]) {
               break;
            }
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            //如果一个数不能取多次  这里每次进行下一次递归时将startIndex + 1 即排除当前避免取多次
            recursion(candidates, i, remainTarget - candidates[i], combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}


