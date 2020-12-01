//
// Created by John on 2020/5/18.
//

#include <printf.h>
#include <iostream>
#include "cstring"
#include "atomic"
#include "vector"

using namespace std;

class Solution {
public:
//    vector<int> printNumbers(int n) {
//        vector<int> res;
//        if (n <= 0) {
//            return res;
//        }
//        char *number = new char[n + 1];
//        memset(number, '0', n);
//        number[n] = '\n';
//
//        while (!increment(number)) {
//            printNumber(res, number);
//        }
//        delete[] number;
//        return res;
//    }
//
//    bool increment(char *number) {
//        bool isOverFlow = false;
//        int nTakeOver = 0;
//        int nLength = strlen(number);
//
//        for (int i = nLength - 1; i >= 0; --i) {
//            int nSum = number[i] - '0' + nTakeOver;
//            if (i == nLength - 1) {
//                nSum++;
//            }
//            if (nSum >= 10) {
//                if (i == 0) {
//                    isOverFlow = true;
//                } else {
//                    nSum -= 10;
//                    nTakeOver = 1;
//                    number[i] = '0' + nSum;
//                }
//            } else {
//                number[i] = '0' + nSum;
//                break;
//            }
//        }
//        return isOverFlow;
//    }
//
//    void printNumber(vector<int> & res, char * number) {
//        bool isBeginning0 = true;
//        int nLength = strlen(number);
//
//        for (int i = 0; i < nLength; ++i) {
//            if (isBeginning0 && number[i] != '0') {
//                isBeginning0 = false;
//            }
//            if (!isBeginning0) {
//                res.push_back(number[i] - '0');
//                printf("%c", number[i]);
//            }
//        }
//        printf("\t");
//    }



//    vector<int> printToMaxOfNDigits(int n) {
//        vector<int> res;
//        if (n <= 0) {
//            return res;
//        }
//        char *number = new char[n + 1];
//        memset(number, '0', n);
//        number[n] = '\0';
//
//        while (!Increment(number)) {
//            PrintNumber(res, number);
//        }
//        delete[] number;
//        return res;
//    }
//
//    bool Increment(char *number) {
//        bool isOverflow = false;
//        int nTakeOver = 0;
//        int nLength = strlen(number);
//
//        for (int i = nLength - 1; i >= 0 ; --i) {
//            int nSum = number[i] - '0' + nTakeOver;
////            int nSum = number[i] - '0' + nTakeOver;
//            if (i == nLength - 1) {
//                nSum++;
//            }
//            if (nSum >= 10) {
//                if (i == 0) {
//                    isOverflow = true;
//                } else {
//                    nSum -= 10;
//                    nTakeOver = 1;
//                    number[i] = '0' + nSum;
//                }
//            } else {
//                number[i] = '0' + nSum;
//                break;
//            }
//        }
//        return isOverflow;
//    }
//
//    void PrintNumber(vector<int> & res, char * number) {
//        bool isBeginning0 = true;
//        int nLength = strlen(number);
//
//        for (int i = 0; i < nLength; ++i) {
//            if (isBeginning0 && number[i] != '0') {
//                isBeginning0 = false;
//            }
//            if (!isBeginning0) {
////                res.push_back();
//                printf("%c", number[i]);
//                cout << (int)number[i] << endl;
//            }
//        }
//        printf("\t");
//    }

    vector<int> res;
    vector<int> printNumbers(int n) {
        if (n <= 0) {
            return res;
        }
        // 创建一个能容纳最大值的字符数组，由于有一位要存储 '\0', 因此要开大一格
        char * number = new char[n + 1];
        // 初始全部设置为0
        memset(number, '0', n);
        number[n] = '\0'; // 第n位设为 '\0'
        while (!increment(number)) {
            printNumber(number);
        }
        delete[] number;
        return res;
    }

    bool increment(char * number) { // 形参传递char*指针
        bool isOverFlow = false; // 检测是否越界
        int nTakeOver = 0; // 存储进位
        int nLength = strlen(number);  // 长度为n, 不是 n + 1
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                // 如果是第一位, 进位
                nSum++;
            }
            if (nSum >= 10) {
                // 有进位
                if (i == 0) {
                    // 如果是最高位有进位，说明超过了给定的最大值，越界
                    isOverFlow = true;
                } else {
                    // 非最高位有进位
                    nTakeOver = 1;
                    number[i] = nSum - 10 + '0'; // 对第i位进行设置
                }
            } else {
                // 没有进位
                // 设置第i位数字 并直接跳出循环
                number[i] = nSum + '0';
                break;
            }
        }
        return isOverFlow;
    }

    void printNumber(char * number) {
        string s = "";
        bool isBegin0 = true;
        while (*number != '\0') {
            if (isBegin0 && *number != '0') {
                isBegin0 = false;
            }

            // 碰到 '0', 则不输出
            if (!isBegin0) {
                s += *number;
            }
            number++;
        }
        int num = stoi(s); //转为整数
        res.push_back(num);
    }
};

//int main() {
//    Solution *solution = new Solution();
//    vector<int> res = solution->printToMaxOfNDigits(2);
//    cout << "asdf" << endl;
//}