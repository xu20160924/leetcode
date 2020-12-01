//
// Created by John on 2020/1/14.
//

#ifndef UNTITLED_ONEFIVETWO_H
#define UNTITLED_ONEFIVETWO_H

#include <algorithm>

using namespace std;

class OneFiveTwo {
public:
    static int maxProduct(int A[], int n) {
        int r = A[0];
        for (int i = 1, imax = r, imin = r; i < n; i++ ) {
            if (A[i] < 0) {
                swap(imax, imin);
            }

            imax = max(A[i], imax * A[i]);
            imin = min(A[i], imin * A[i]);

            r = max(r, imax);
        }
        return r;
    }
};


//int main() {
//    int input[] = {2, 3, -2, 4};
////    printf("%d", 3);
//    printf("%d", OneFiveTwo::maxProduct(input, 4));
//
//
//}


//int main() {
//    int input[] = {2, 3, -2, 4};
//    OneFiveTwo::maxProduct(input, sizeof(input));
//}



#endif //UNTITLED_ONEFIVETWO_H
