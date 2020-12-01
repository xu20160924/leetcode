//
// Created by John on 2020/3/2.
//
#include "vector"

using namespace std;

class Solution{
public:
    int canCompleteCircurit(vector<int> & gas, vector<int> &cost) {
        int start(0), total(0), tank(0);
        // if car fais at 'start', record the next station
        for (int i = 0; i < gas.size(); i++) {
            if ((tank = tank + gas[i] - cost[i]) < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return (total + tank < 0) ? -1 : start;
    }

    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int start = gas.size() - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                ++end;
            } else {
                --start;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }
};