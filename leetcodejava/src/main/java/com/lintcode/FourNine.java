package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-16 20:36
 * @description: 49
 **/
public class FourNine {

    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            while (i <= j && Character.isLowerCase(chars[i])) {
                i++;
            }
            while (i <= j && Character.isUpperCase(chars[j])) {
                j--;
            }

            if (i <= j) {
               char temp = chars[i];
               chars[i] = chars[j];
               chars[j] = temp;
               i++;
               j--;
            }
        }
    }
}
