package com.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-04-01 09:45
 * @description: 573  Build Post Office 2
 **/
public class FiveSevenThree {

    class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    public int[][] grid;
    public int n, m;
    public int[] deltaX = {0, 1, -1, 0};
    public int[] deltaY = {1, 0, 0, -1};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        setGrid(grid);

        /**
         * 这里是先找到所有的房子作为起点进行bfs
         */
        List<Coordinate> houses = getCoordinates(HOUSE);
        int[][] distanceSum = new int[n][m];
        int[][] visitedTimes = new int[n][m];
        for (Coordinate house : houses) {
            bfs(house, distanceSum, visitedTimes);
        }
        int shortest = Integer.MAX_VALUE;
        List<Coordinate> empties = getCoordinates(EMPTY);
        for (Coordinate empty : empties) {
            /**
             * 这里取出访问次数与房子数相同的节点，然后再取当前节点的长度和
             * 这么做的原因是最近的节点必定要所有房子都经过也就是都访问，所以访问次数应与房子数相同
             */
            if (visitedTimes[empty.x][empty.y] != houses.size()) {
                continue;
            }
            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }

    private boolean inBound(Coordinate coor) {
        if (coor.x < 0 || coor.x >= 0) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        return grid[coor.x][coor.y] == EMPTY;
    }

    private void bfs(Coordinate start, int[][] distanceSum, int[][] visitedTimes) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] hash = new boolean[n][m];

        queue.offer(start);
        hash[start.x][start.y] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int temp = 0; temp < size; temp++) {
                Coordinate coor = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Coordinate adj = new Coordinate(coor.x + deltaX[i], coor.y + deltaY[i]);
                    if (!inBound(adj)) { // 不是空的位置都跳过了,因此也就不用考虑墙的问题
                        continue;
                    }
                    if (hash[adj.x][adj.y]) {
                        continue;
                    }
                    queue.offer(adj);
                    hash[adj.x][adj.y] = true;
                    distanceSum[adj.x][adj.y] += steps; //当前节点路径长度等于当前加上之前总共走的长度
                    visitedTimes[adj.x][adj.y]++;  // 记录当前节点访问的次数
                }
            }
        }
    }


    private List<Coordinate> getCoordinates(int type) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }

    private void setGrid(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
    }
}
