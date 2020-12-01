package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-14 15:14
 * @description: 8 Rotate String
 **/
public class Eight {

    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
           char temp = str[i];
           str[i] = str[j];
           str[j] = temp;
        }
    }

}
