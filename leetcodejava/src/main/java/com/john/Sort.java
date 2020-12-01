package com.john;

/**
 * @author: John
 * @date: 2020-04-09 14:24
 * @description: Sort
 **/
public class Sort {

    public void mergeSort(double[] a, double[] tmp) {
        int width;
        for (width = 1; width < a.length; width = 2 * width) {
            // Combine pairs of array a of width "width"
            int i;
            for (i = 0; i < a.length; i = i + 2 * width) {
                int left, middle, right;
                left = i;
                middle = i + width;
                right = i + 2 * width;
                merge(a, left, middle, right, tmp);
            }
              /* ===============================================
            All merge() are done for ONE complete iteration

	    NOW we copy tmp[ ] back to a[ ]
	    =============================================== */
              for (i = 0; i < a.length; i++) {
                  a[i] = tmp[i];
              }
        }
    }

    /* ======================================================
      Merge does this:

      1. Merge 2 SORTED adjacent pieces of array a[ ] into
         a SORTED array tmp[ ]:

            left array (sorted)         right array (sorted)
           a[iLeft ... iMiddle-1]      a[iMiddle... iRight]
                   \                         /
                    \                       /  sort
                     \                     /
                    tmp[ iLeft ... iRight ]
                                |
                                | Copy back !
                                V
                      a[ iLeft... iRight ]
`
      2. Copy the merged result in tmp[ ] back to a[ ]

      The SAME portion of the array tmp[ ] is used !!!
      ====================================================== */
    public void merge(double[] a, int left, int middle, int right, double[] tmp) {
        int i, j, k;
        i = left; // Re-adjust the indices
        j = middle;
        k = left;

        while (i < middle || j < right) { // It's the same algorithm
            if (i < middle && j < right) {
                // Both array have elements
                if (a[i] < a[j]) {
                    tmp[k++] = a[i++];
                } else {
                    tmp[k++] = a[j++];
                }
            } else if (i == middle) {
                tmp[k++] = a[j++];  // a is empty
            } else if (j == right) {
                tmp[k++] = a[i++];  // b is empty
            }
        }
//        /* =================================
//         Copy tmp[] back to a[]
//         ================================= */
//        for (i = left; i < right; i++) {
//            a[i] = tmp[i];
//        }
    }
}
