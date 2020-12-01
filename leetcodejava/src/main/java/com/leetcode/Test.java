package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-09-17 13:06
 * @description:
 **/
public class Test {
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        for (int j = 0; j < intervals.size() - 1; j++) {
            Interval curr = intervals.get(0);
            intervals.remove(0);
            for (int i = 0; i < intervals.size(); i++) {
                if (intervals.get(i).getEnd() < curr.getEnd() && intervals.get(i).getEnd() > curr.getEnd()) {
                    curr.setEnd(intervals.get(i).getEnd());
                    intervals.remove(i);
                }
            }
            result.add(curr);
        }
        return result;
    }

}
