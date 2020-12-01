//
// Created by John on 2019/12/22.
//

#ifndef UNTITLED_TEST_H
#define UNTITLED_TEST_H

#include <iostream>
#include <string>
//#include <altivec.h>
#include <vector>
#include <stdint.h>
#include <cstring>
#include <climits>

using namespace std;

class Test {
public:
    static int myAtoi(std::string s) {
        int res = 0;
        int i = 0;
        int flag = 1;
        while (s[i] == ' ') {
            i++;
        };
        if (s[i] == '-') {
            flag = -1;
        }
        if (s[i] == '+' || s[i] == '-') {
            i++;
        }
        while (i < s.size() && isdigit(s[i])) {
            // 对ASCII做处理后直接转整形
            int r = s[i] - '0';
            //res >= INT_MAX / 10
            //需要进行个位数判断 > 7
            if (res > INT32_MAX / 10 || (res == INT32_MAX / 10 && r > 7)) {
                return flag > 0 ? INT32_MAX : INT32_MIN;
            }
            res = res * 10 - +r;
            i++;
        }
        return flag > 0 ? res : -res;
    }

//    violence match string
    static int violentMatch(char * s, char* p) {
        int sLen = strlen(s);
        int pLen = strlen(p);

        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen) {
            if (s[i] ==  p[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j - 0;
            }
        }
        if (j == pLen) {
            return i -j;
        } else {
            return -1;
        }
    }
    static int kmpSearch(char* s, char* p) {
        int i = 0;
        int j = 0;
        int sLen = strlen(s);
        int pLen = strlen(p);
        while (i < sLen && j < pLen) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else  {
//                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }


    }
    /**
     * swap root node with last node of array
     */
    static void Swap(int *heap, int len) {
        int temp;

        temp = heap[0];
        heap[0] = heap[len-1];
        heap[len-1] = temp;
    }
    /**
     * build big top pile
     */
    static void BuildMaxHeap(int *heap, int len) {
        int i;
        int temp;
        for (i = len/2-1; i >= 0; i --) {
            if ((2*i+1) < len && heap[i] < heap[2*i+1]) { // root node less than left subtree
                temp = heap[i];
                heap[i] = heap[2*i+1];
                heap[2*i+1] = temp;
                // check whether left subtree that had swaped satisfy feature of big top pile, if not swap again
                if ((2*(2*i+1)+1 < len && heap[2*i+1] < heap[2*(2*i+1)+1]) || (2*(2*i+1)+2 < len && heap[2*i+1] < heap[2*(2*i+1)+2])) {
                    BuildMaxHeap(heap, len);
                }
            }
            if ((2*i+2) < len && heap[i] < heap[2*i+2]) {   //root node less right subtree
                temp = heap[i];
                heap[i] = heap[2*i+2];
                heap[2*i+2] = temp;
                // check whether right subtree that had swaped satisfy feature of big top pile, if not swap again
                if ((2*(2*i+2)+1 < len && heap[2*i+2] < heap[2*(2*i+2)+1]) || (2*(2*i+2)+2 < len && heap[2*i+2] < heap[2*(2*i+2)+2])) {
                    BuildMaxHeap(heap, len);
                }
            }
        }
    }

    static int hammingWeight(uint32_t n) {
        int res = 0;
        for (; n; n &= n - 1) {
            ++res;
        }
        return res;
    }

    static vector<int> countBits(int num) {
        vector<int> bits(num+1, 0);
        for (int i = 1; i <= num; i ++) {
            printf("result: %d \n",bits[i & (i - 1)]);
            printf("aa %d \n", (i & (i - 1)));
            bits[i] += bits[i & (i - 1)] + 1;
//            printf("%s", bits[i]);
        }
        return bits;
    }
//    static int minimumTotal(vector<vector<int> > &triangle)
//    {
//        vector<int> mini = triangle[triangle.size() - 1];
//        for (int i = triangle.size() - 2; i >= 0; --i) {
//            for (int j = 0; j < triangle[i].size(); ++j) {
//                mini[j] = triangle[i][j] + min(mini[j], mini[j + 1]);
//                printf("%d", mini[j]);
//            }
//        }
//        return mini[0];
//    }
public:
    static int minimumTotal(vector<vector<int> > &triangle) {
        vector<int> mini = triangle[triangle.size() - 1];
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle[i].size(); ++j) {
                mini[j] = triangle[i][j] + min(mini[j], mini[j + 1]);
            }
        }
        return mini[0];
    }

public:
    static int maxProduct(vector<int> &nums) {
        int n = nums.size(), mp = INT_MIN;
        for (int i = 0; i < n; ++i) {
            int cur = 1;
            for (int j = i; j < n; j++) {

                mp = max(mp, cur *= nums[j]);
                printf("cur: %d  \n", cur);
                printf("nums[j]: %d  \n", nums[j]);
                printf("mp: %d  \n", mp);
                printf("--------- \n");

            }
        }
        return mp;
    }



};
//int main() {
////    printf("%s", );
////    vector<vector<int>> input = {
////    };
////    vector<int> a, b, c, d;
////    a.push_back(4);
////    a.push_back(1);
////    a.push_back(8);
////    a.push_back(3);
////
////    b.push_back(6);
////    b.push_back(5);
////    b.push_back(7);
////
////    c.push_back(3);
////    c.push_back(4);
////
////    d.push_back(2);
////
////    vector<vector<int> > input;
////    input.push_back(d);
////    input.push_back(c);
////    input.push_back(b);
////    input.push_back(a);
//
//    vector<int> input;
//    input.push_back(2);
//    input.push_back(3);
//    input.push_back(-2);
//    input.push_back(4);
//
//    printf("%d", Test::maxProduct(input));
//
////    for (int i = 0; i < bits.size(); ++i) {
////        cout<<bits[i]<<"Test::countBits(2) ";
////    }
////    printf("%s", bits);
//    //    int a[6] = {7,3,8,5,1,2};
////    int len = 6;
////    int i;
////    for (i = len; i > 0; i--) {
////        Test::BuildMaxHeap(a, i);
////        Test::Swap(a, i);
////    }
////    for (int i = 0; i < len; i++) {
////        printf("%d ", a[i]);
////    }
//
//
////    std::string a = "4193 with words";
////    printf(reinterpret_cast<const char *>(Test::myAtoi(a)));
////    //    std::cout << "Hello, World!" << std::endl;
////    return 0;
//}
//


#endif //UNTITLED_TEST_H
