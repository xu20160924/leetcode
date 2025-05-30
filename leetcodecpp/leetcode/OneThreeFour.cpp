//
// Created by John on 2020/3/2.
//
#include <iostream>
#include <ostream>

#include "vector"

using namespace std;

class Solution{
public:
//    int canCompleteCircurit(vector<int> & gas, vector<int> &cost) {
//        int start(0), total(0), tank(0);
//        // if car fais at 'start', record the next station
//        for (int i = 0; i < gas.size(); i++) {
//            if ((tank = tank + gas[i] - cost[i]) < 0) {
//                start = i + 1;
//                total += tank;
//                tank = 0;
//            }
//        }
//        return (total + tank < 0) ? -1 : start;
//    }
//
    // int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
    //     int start = gas.size() - 1;
    //     int end = 0;
    //     int sum = gas[start] - cost[start];
    //     while (start > end) {
    //         if (sum >= 0) {
    //             sum += gas[end] - cost[end];
    //             ++end;
    //         } else {
    //             --start;
    //             sum += gas[start] - cost[start];
    //         }
    //     }
    //     return sum >= 0 ? start : -1;
    // }


      int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
            int n = gas.size();
            int totalSurplus = 0;
            int surplus = 0;
            int start = 0;

            for (int i = 0; i < n; i++) {
                  totalSurplus += gas[i] - cost[i];
                  surplus += gas[i] - cost[i];
                  if (surplus < 0) {
                        surplus = 0;
                        start = i + 1;
                  }
            }
            return (totalSurplus < 0) ? -1 : start;
      }

      // int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
      //       int totalCost = gas[0] - cost[0];
      //       int start = -1;
      //       for (int i = 1; i < gas.size(); i++) {
      //
      //             int currentCost = gas[i] - cost[i];
      //             if ((totalCost + currentCost) > totalCost) {
      //                   start = i;
      //             }
      //             totalCost += currentCost;
      //       }
      //       return start;
      // }
};

int main(int argc, char *argv[]) {
      vector<int> gas = {5, 1, 2, 3, 4};
      vector<int> cost = {4, 4, 1, 5, 1};
      Solution *solution = new Solution();
      cout << solution->canCompleteCircuit(gas, cost) << endl;
}

