//
// Created by John on 2025/5/7.
//

#include <cmath>
#include <unordered_map>
#include <__math/roots.h>
#include <vector>
using namespace std;

class Solution {
public:
    vector<bool> isPrimeCache;
    int countPrimes(int n) {
        // assume all number are prime number at initially
        vector<bool> isPrime(n, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

};