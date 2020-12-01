//
// Created by John on 2020/2/13.
//

#include "SixNineFive.h"
#include <vector>
#include <iostream>

using namespace std;

class Solution {
//public:
//    int maxAreaOfIsLand(vector<vector<int> > grid) {
//        int max_area = 0;
//        for (int i = 0; i < grid.size(); i++) {
//            for (int j = 0; j < grid[0].size(); j++) {
//                if (grid[i][j] == 1) {
//                    max_area = max(max_area, areaOfIsland(grid, i, j));
//                }
//            }
//        }
//        return max_area;
//    }
//
//private:
//    int areaOfIsland(vector<vector<int> > grid, int i, int j) {
//        if (i >= 0 and i < grid.size() and j >= 0 and j < grid[i].size() and grid[i][j] == 1) {
//            return 1 + areaOfIsland(grid, i+1, j) + areaOfIsland(grid, i-1,j) + areaOfIsland(grid, i, j+1) + areaOfIsland(grid, i, j-1);
//        }
//        return 0;
//    }

public:
    int maxAreaOfIsland(vector<vector<int> >& grid) {
        int max_area = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1) {
                    max_area = max(max_area, areaOfIsland(grid, i, j));
                }
            }
        }
        return max_area;
    }
private:
    int areaOfIsland(vector<vector<int> > &grid, int i, int j) {
        if (i >= 0 && i < grid.size() && j >= 0 && j < grid[0].size() && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + areaOfIsland(grid, i+1, j) + areaOfIsland(grid, i-1, j) + areaOfIsland(grid, i, j+1) + areaOfIsland(grid, i, j-1);
        }
        return 0;
    }
};

/*
int main() {
    Solution *solution = new Solution();
    vector<vector<int> > grid;
    vector<int> nums1, nums2, nums3;
    nums1.push_back(0);
    nums1.push_back(0);
    nums1.push_back(1);
    nums1.push_back(1);

    nums2.push_back(0);
    nums2.push_back(1);
    nums2.push_back(1);
    nums2.push_back(1);

    nums3.push_back(0);
    nums3.push_back(0);
    nums3.push_back(0);
    nums3.push_back(0);
    grid.push_back(nums1);
    grid.push_back(nums2);
    grid.push_back(nums3);
    printf("%d", solution->maxAreaOfIsland(grid));
};*/
