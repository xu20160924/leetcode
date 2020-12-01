//
// Created by John on 2020/3/22.
//

#include "vector"
#include "iostream"
#include "complex"
#include "queue"

using namespace std;
class Solution{
public:
//    int numSquares(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        // cntPerfectSquares[i] = the least number of perfect square numbers
//        // which sum to i. Note that cntPerfectSquares[0] is 0.
//        vector<int> cntPerfectSquares(n + 1, INT_MAX);
//        cntPerfectSquares[0] = 0;
//        for (int i = 1; i <= n; ++i) {
//            // For each i, it must be the sum of some number (i - j *j) and
//            // a perfect square number(j*j).
//            for (int j = 1; j <= n; j++) {
//                cntPerfectSquares[i] = min(cntPerfectSquares[i], cntPerfectSquares[i - j* j]);
//            }
//        }
//        return cntPerfectSquares.back();
//    }

//    int numSquares(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        // cntPerfectSquares[i] = the least number of perfect square numbers
//        // which sum to i.
//        static vector<int> cntPerfectSquares({0});
//        while (cntPerfectSquares.size() <= n) {
//            int m = cntPerfectSquares.size();
//            int cntSquares = INT_MAX;
//            for (int i = 1; i*i <= m; ++i) {
//                cntSquares = min(cntSquares, cntPerfectSquares[m - i*i] + 1);
//            }
//            cntPerfectSquares.push_back(cntSquares);
//        }
//        return cntPerfectSquares[n];
//    }

    int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        static vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minNum = INT_MAX;
            int j = 1;
            while (i - j*j >= 0) {
                minNum = min(minNum, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = minNum;
        }
        return dp[n];
    }

private:
    int is_square(int n) {
        int sqrt_n = (int)(sqrt(n));
        return (sqrt_n * sqrt_n == n);
    }

public:
    // Based on Largrange's Four Square theorem, there
    // are only 4 possible results: 1, 2, 3, 4
//    int numSquares(int n) {
//        // If n is a perfect square, return 1
//        if (is_square(n)) {
//            return 1;
//        }
//        // The result is 4 if only if n can be written in the
//        // form of 4 ^k * (8 * m + 7).
//        while ((n & 3) == 0) { // n%4 == 0
//            n >>= 2;
//        }
//        if ((n & 7) ==  7) {  // n % 8 == 7
//            return 4;
//        }
//        // Check whether 2 is the result.
//        int sqrt_n = (int)(sqrt(n));
//        for (int i = 1; i <= sqrt_n; i++) {
//            if (is_square(n - i*i)) {
//                return 2;
//            }
//        }
//        return 3;
//    }
//    int numSquares(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        // perfectSquares contain all perfect square numbers which
//        // are smaller than or equal to n.
//        vector<int> perfectSquares;
//        // cntPerfectSquares[i - 1] = the least number of perfect
//        // sqaure numbers which sum to i
//        vector<int> cntPerfectSquares(n);
//
//        // Get all the perfect square numbers which are smaller than or equal to n.
//        for (int i = 1; i*i <= n; ++i) {
//            perfectSquares.push_back(i*i);
//            cntPerfectSquares[i*i - 1] = 1;
//        }
//        // if n is a perfect sqaure number, return 1 immediately
//        if (perfectSquares.back() == n) {
//            return 1;
//        }
//        // Consider a graph which consists of number 0， 1.... n as
//        // its nodes. Node j is connected to node i via an edge if
//        // and only if eighter j = i + (a perfect sqaure number) or
//        // i = j + (a perfect sqaure number). Starting from node 0，
//        // do the breadth—first search. If we reach node n at step m,
//        // then the least number of perfect square numbers which sum to
//        // n is m. Here since we have already obtained the perfect square numbers,
//        // we have actually finished the search at step 1.
//        queue<int> searchQ;
//        for (auto & i : perfectSquares) {
//            searchQ.push(i);
//        }
//        int currCntPerfectSquares = 1;
//        while (!searchQ.empty()) {
//            currCntPerfectSquares++;
//            int searchQSize = searchQ.size();
//            for (int i = 0; i < searchQSize; ++i) {
//                int tmp = searchQ.front();
//                // Check the neighbors of node tmp which are the sum
//                // of tmp and a perfect square number.
//                for (auto &j : perfectSquares) {
//                    if (tmp + j == n) {
//                        // We have reached node n.
//                        return currCntPerfectSquares;
//                    } else if ((tmp + j < n) && (cntPerfectSquares[tmp + j - 1]) == 0) {
//                        // If cntPerfectSquares[tep + j - 1] > 0, this is not
//                        // the first time that we visit this node and we should
//                        // skip the node(tmp + j).
//                        cntPerfectSquares[tmp + j - 1] = currCntPerfectSquares;
//                        searchQ.push(tmp + j);
//                    } else if (tmp + j > n) {
//                        // We dont need to consider the nodes which are greater that n
//                        break;
//                    }
//                }
//                searchQ.pop();
//            }
//        }
//        return 0;
//    }

};

//int main() {
//    Solution * solution = new Solution();
//    cout << solution->numSquares(13) << endl;
//}