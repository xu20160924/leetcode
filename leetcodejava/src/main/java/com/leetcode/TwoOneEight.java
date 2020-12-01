package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-22 10:21
 * @description: 218
 **/
public class TwoOneEight {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }
        return merge(buildings, 0, buildings.length - 1);
    }

    private List<List<Integer>> merge(int[][] buildings, int start, int end) {
        List<List<Integer>> res = new ArrayList<>();
        // 只有一个建筑, 将[x, h], [y, 0] 加入结果
        if (start == end) {
            List<Integer> temp = new ArrayList<>();
            temp.add(buildings[start][0]);
            temp.add(buildings[start][2]);
            res.add(temp);

            temp = new ArrayList<>();
            temp.add(buildings[start][1]);
            temp.add(00);
            res.add(temp);
            return res;
        }

        int mid = (start + end) >>> 1;
        // 第一组解
        List<List<Integer>> skyline1 = merge(buildings, start, mid);
        // 第二组解
        List<List<Integer>> skyline2 = merge(buildings, mid + 1, end);

        // 下边将两组解合并
        int h1 = 0;
        int h2 = 0;
        int i = 0;
        int j = 0;
        while (i < skyline1.size() || j < skyline2.size()) {
            long x1 = i < skyline1.size() ? skyline1.get(i).get(0) : Long.MAX_VALUE;
            long x2 = j < skyline2.size() ? skyline2.get(j).get(0) : Long.MAX_VALUE;
            long x = 0;
            // 比较两个坐标
            if (x1 < x2) {
                h1 = skyline1.get(i).get(1);
                x = x1;
                i++;
            } else if (x1 > x2) {
                h1 = skyline2.get(j).get(1);
                x = x2;
                j++;
            } else {
                h1 = skyline1.get(i).get(1);
                h2 = skyline2.get(j).get(1);
                x = x1;
                i++;
                j++;
            }
            // 更新height
            int height = Math.max(h1, h2);
            // 重复的解不要加入
            if (res.isEmpty() || height != res.get(res.size() - 1).get(1)) {
                List<Integer> temp = new ArrayList<>();
                temp.add((int) x);
                temp.add(height);
                res.add(temp);
            }
        }
        return res;
    }

//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<int[]> height = new ArrayList<>();
//
//        for (int[] b: buildings) {
//            height.add(new int[]{b[0], -b[2]});
//            height.add(new int[]{b[1], b[2]});
//        }
//
//        Collections.sort(height,
//                (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
//        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
//        pq.offer(0);
//        int prev = 0;
//
//        for (int[] h:height) {
//            if (h[1] < 0) {
//                pq.offer(-h[1]);
//            } else {
//                pq.remove(h[1]);
//            }
//            int cur = pq.peek();
//            if (cur != prev) {
//                result.add(new ArrayList<Integer>(){{
//                    add(h[0]);
//                    add(cur);
//                }});
//                prev = cur;
//            }
//        }
//        return result;
//    }

//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        List<List<Integer>> res = new ArrayList<>();
//
//        List<int[]> heights = new ArrayList<>();
//        for (int[] b : buildings) {
//            heights.add(new int[]{b[0], -b[2]});
//            heights.add(new int[]{b[1], b[2]});
//        }
//        // 如果left 和 right 重合 按高度取最高，否则按距离取最远
//        Collections.sort(heights,
//                (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
//        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
//        heightMap.put(0, 1);
//        int preHeight = 0;
//
//        for (int[] h : heights) {
//            // 左边端点
//            if (h[1] < 0) {
//                // 取- 转回正数
//                Integer cur = heightMap.get(-h[1]);
//                cur = (cur == null) ? 1 : cur + 1;
//                heightMap.put(-h[1], cur);
//            } else {
//                Integer cur = heightMap.get(h[1]);
//                if (cur == 1) {
//                    heightMap.remove(h[1]);
//                } else {
//                    heightMap.put(h[1], cur - 1);
//                }
//            }
//
////            if (h[1] < 0) {
////                heightMap.put(-h[1], 0);
////            } else {
////                heightMap.remove(h[1]);
////            }
//
//            int curHeight = heightMap.firstKey();
//            // 转折点
//            if (preHeight != curHeight) {
//                res.add(new ArrayList<Integer>() {{
//                    add(h[0]);
//                    add(curHeight);
//                }});
//                preHeight = curHeight;
//            }
//        }
//        return res;
//    }

    class Point implements Comparable<Point> {
        private int x;
        private int height;
        private boolean isStart;

        public Point(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        // 主要考虑三种边界情况
        @Override
        public int compareTo(Point p) {
            // 如果两者x坐标不是同一个, 取最大的x坐标
            if (this.x != p.x) {
                return this.x - p.x;
            } else { // 两者重叠的情况
                // 如果两个点都是起点， 取最左边高度最大的
                if (this.isStart && p.isStart) {
                    return p.height - this.height;
                }
                // 如果两个点都不是起点，取两者高度最大的
                if (!this.isStart && !p.isStart) {
                    return this.height - p.height;
                }
                // 如果以上不成立, 取最右边的高度
                return this.isStart ? -1 : 1;
            }
        }
    }

//    public List<int[]> getSkyline(int[][] buildings) {
//        int len = buildings.length;
//        if (len == 0 || buildings[0].length == 0) {
//            return new ArrayList<>();
//        }
//
//        // 每栋建筑有两个关键点
//        Point[] points = new Point[len * 2];
//        int index = 0;
//
//        // 初始化所有关键点的数组
//        for (int[] building : buildings) {
//            int start = building[0];
//            int end = building[1];
//            int h = building[2];
//            points[index++] = new Point(start, h, true);
//            points[index++] = new Point(end, h, false);
//        }
//
//        // 将这些点按照我们希望的顺序排序
//        Arrays.sort(points);
//        // 用Collections.reverseOrder() 建立大根堆
//        // 这样就可以找到当前最高的高度
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        queue.offer(0);
//        List<int[]> res = new ArrayList<>();
//
//        int prevMaxVal = 0;
//        for (Point point : points) {
//            if (point.isStart) {
//                queue.offer(point.height);
//                int curMaxVal = queue.peek();
//                // 如果最大值变化了(只能变大), 说明这个点应该被记录
//                if (curMaxVal > prevMaxVal) {
//                    res.add(new int[]{point.x, point.height});
//                    prevMaxVal = curMaxVal;
//                }
//            } else {
//                queue.remove(point.height);
//                int curMaxVal = queue.peek();
//                // 最大值变化了(只能变小) 记录当前点
//                if (curMaxVal < prevMaxVal) {
//                    res.add(new int[]{point.x, curMaxVal});
//                    prevMaxVal = curMaxVal;
//                }
//            }
//        }
//        return res;
//    }


//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        List<List<Integer>> res = new ArrayList<>();
//        int len = buildings.length;
//
//        if (len == 0 || buildings[0].length == 0) {
//            return res;
//        }
//
//        // Every buildings has two key points.
//        Point[] points = new Point[len * 2];
//        int index = 0;
//
//        for (int[] b : buildings) {
//            points[index++] = new Point(b[0], b[2], true);
//            points[index++] = new Point(b[1], b[2], false);
//        }
//
//        Arrays.sort(points);
////        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
////        map.put(0, 1);
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(0);
//        int pre = 0;
//
//        for (Point point : points) {
//            if (point.isStart) {
//                set.add(point.height);
//                int cur = set.last();
//                if (cur > pre) {
//                    res.add(new ArrayList<Integer>() {{
//                        add(point.x);
//                        add(point.height);
//                    }});
//                    pre = cur;
//                }
//            } else {
//                set.remove(point.height);
//                int cur = set.first();
//                if (cur < pre) {
//                    res.add(new ArrayList<Integer>() {{
//                        add(point.x);
//                        add(point.height);
//                    }});
//                    pre = cur;
//                }
//            }
//        }
//        return res;
//    }

//    int prevMaxVal = 0;
//        for (Point point : points) {
//            if (point.isStart) {
//                queue.offer(point.height);
//                int curMaxVal = queue.peek();
//                // 如果最大值变化了(只能变大), 说明这个点应该被记录
//                if (curMaxVal > prevMaxVal) {
//                    res.add(new int[]{point.x, point.height});
//                    prevMaxVal = curMaxVal;
//                }
//            } else {
//                queue.remove(point.height);
//                int curMaxVal = queue.peek();
//                // 最大值变化了(只能变小) 记录当前点
//                if (curMaxVal < prevMaxVal) {
//                    res.add(new int[]{point.x, curMaxVal});
//                    prevMaxVal = curMaxVal;
//                }
//            }
//        }
//        return res;


//    class BuildingPoint implements Comparable<BuildingPoint> {
//        int x;
//        boolean isStart;
//        int height;
//        @Override
//        public int compareTo(BuildingPoint o) {
//            //first compare by x.
//            // If they are same then use this logic
//            // If two starts are compared then higher height building should be picked first.
//            // If two ends are compared then lower height building should be picked first.
//            // If one start and end is compared then start should appear before end.
//
//            if (this.x != o.x) {
//                return this.x - o.x;
//            } else {
//                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
//            }
//        }
//    }
//    public List<int[]> getSkyline(int[][] buildings) {
//        // for all start and end of buildings
//        // put them into List of BuildingPoint
//        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
//        int index = 0;
//        for (int building[] : buildings) {
//            buildingPoints[index] = new BuildingPoint();
//            buildingPoints[index].x = building[0];
//            buildingPoints[index].isStart = true;
//            buildingPoints[index].height = building[2];
//
//            buildingPoints[index + 1] = new BuildingPoint();
//            buildingPoints[index + 1].x = building[1];
//            buildingPoints[index + 1].isStart = false;
//            buildingPoints[index + 1].height = building[2];
//            index += 2;
//        }
//        Arrays.sort(buildingPoints);
//
//        // using TreeMap because it gives log time performance.
//        // PriorityQueue in java does not support remove(object) operation in log time.
//        TreeMap<Integer, Integer> queue = new TreeMap<>();
//        // PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
//        queue.put(0, 1);
//        // queue1.add(0);
//        int prevMaxHeight = 0;
//        List<int[]> result= new ArrayList<>();
//        for (BuildingPoint buildingPoint : buildingPoints) {
//            // if it is start of building then add the height to map.
//            // If height already exists then increment the value.
//            if (buildingPoint.isStart) {
//                queue.compute(buildingPoint.height, (key, value) -> {
//                    if (value != null) {
//                        return value + 1;
//                    }
//                    return 1;
//                });
//            }
//            // queue1.add(cp.height);
//            else {
//                // if it is end of building then decrement or remove the height from map.
//                queue.compute(buildingPoint.height, (key, value) -> {
//                    if (value == 1) {
//                        return null;
//                    }
//                    return value - 1;
//                });
//                // queue1.remove(cp.height);
//            }
//            // peek the current height after addition or removal of building x.
//            int currentMaxHeight = queue.lastKey();
//            // int currentMaxHeight = queue1.peek();
//            // if height changes from previous height then this building x becomes critical x.
//            // So add it to the result.
//            if (prevMaxHeight != currentMaxHeight) {
//                result.add(new int[] {buildingPoint.x, currentMaxHeight});
//                prevMaxHeight = currentMaxHeight;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[][] buildings = new int[5][];
        int[] b1 = new int[]{2, 9, 10};
        int[] b2 = new int[]{3, 7, 15};
        int[] b3 = new int[]{5, 12, 12};
        int[] b4 = new int[]{15, 20, 10};
        int[] b5 = new int[]{19, 24, 8};
        buildings[0] = b1;
        buildings[1] = b2;
        buildings[2] = b3;
        buildings[3] = b4;
        buildings[4] = b5;

//        int[][] buildings = new int[2][];
//        int[] b1 = new int[]{0, 2, 3};
//        int[] b2 = new int[]{2, 5, 3};
//        buildings[0] = b1;
//        buildings[1] = b2;

        TwoOneEight twoOneEight = new TwoOneEight();
        List<List<Integer>> a = twoOneEight.getSkyline(buildings);
        System.out.println("");
    }
}
