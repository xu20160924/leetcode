//
// Created by caidaoliuhai on 2025/12/31.
//
#include "string"
#include "iostream"

using namespace std;

class Solution{
public:
    //      num1 = "123", num2 = "456"  56088
//              456
//      ""
//
//

//      "738"
//     "615"
//    "492"

//     012

    string multiply(string num1, string num2) {
        int n = num1.size();
        int m = num2.size();

        vector<int> v(n + m, 0);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = num1[i] - '0';
                int b = num2[j] - '0';
                int p1 = i + j, p2 = i + j + 1;
                int sum = (a * b);
                sum += v[p2];
                v[p1] += sum / 10;
                v[p2] = sum % 10;
            }

        }

        string res;
        for (int i = 0; i < v.size(); i++) {
            if (res.empty() && v[i] == 0 && i < v.size() - 1) {
                continue;
            }
            res += v[i] + '0';
        }

        return res;
    }
};




int main() {
//    string num1 = "123";
//    string num2 = "456";

    string num1 = "9133";
    string num2 = "0";

//    string num1 = "0";
//    string num2 = "0";

//    string num1 = "408";
//    string num2 = "5";

    Solution *solution = new Solution();
    cout << solution->multiply(num1, num2) << endl;
}