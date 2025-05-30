#include <string>
//
// Created by John on 2025/3/31.
//
using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        // char[] aArr = a.toCharArray(), bArr = b.toCharArray();
        string res;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry >= 0) {
            int sum = carry;
            if (j >= 0) {
                carry += b[j--] - '0';
            }
            if (i >= 0) {
                carry += a[i--] - '0';
            }
            res += to_string(sum % 2);
            sum /= 2;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};