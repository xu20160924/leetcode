package com.leetcode;

/**
 * @author: Denial.AO
 * @date: 2020-12-02 17:52
 * @description: 691
 **/
public class SixNineOne {
//    int best;
//    int[][] stickersCount;
//    int[] targetCount;
//
//    public int minStickers(String[] stickers, String target) {
//        // 26 words
//        int[] targetNaiveCount = new int[26];
//        // count every word of target
//        for (char c : target.toCharArray()) {
//            targetNaiveCount[c - 'a']++;
//        }
//        int[] index = new int[26];
//        int t = 0;
//        for (int i = 0; i < 26; i++) {
//            //  count exist word
//            if (targetNaiveCount[i] > 0) {
//                index[i] = t++;
//            } else {
//                // dont exist
//                index[i] = -1;
//            }
//        }
//
//
//        // copy which is not -1 in targetNaiveCount to targetCount
//        targetCount = new int[t];
//        t = 0;
//        for (int c : targetNaiveCount) {
//            if (c > 0) {
//                targetCount[t++] = c;
//            }
//        }
//
//
//        // count number of sticker's word
//        stickersCount = new int[stickers.length][t];
//        for (int i = 0; i < stickers.length; i++) {
//            for (char c : stickers[i].toCharArray()) {
//                int j = index[c - 'a'];
//                if (j >= 0) {
//                    stickersCount[i][j]++;
//                }
//            }
//        }
//
//        int anchor = 0;
//        for (int i = 0; i < stickers.length; i++) {
//            for (int j = anchor; j < stickers.length; j++) {
//                if (j != i) {
//                    boolean dominated = true;
//                    for (int k = 0; k < t; k++) {
//                        // judge weather stickersCount[j][k] can dominate the result
//                        if (stickersCount[i][k] > stickersCount[j][k]) {
//                            dominated = false;
//                            break;
//                        }
//                    }
//                    if (dominated) {
//                        int[] tmp = stickersCount[i];
//                        stickersCount[i] = stickersCount[anchor];
//                        stickersCount[anchor++] = tmp;
//                        break;
//                    }
//                }
//            }
//        }
//        best = target.length() + 1;
//        search(0, anchor);
//        return best <= target.length() ? best : -1;
//    }
//
//    private void search(int ans, int row) {
//        // 超出最小
//        if (ans >= best) {
//            return;
//        }
//        // find best
//        if (row == stickersCount.length) {
//            for (int c : targetCount) {
//                if (c > 0) {
//                    return;
//                }
//            }
//            best = ans;
//            return;
//        }
//        // find max used
//        int used = 0;
//        for (int i = 0; i < stickersCount[row].length; i++) {
//            if (targetCount[i] > 0 && stickersCount[row][i] > 0) {
//                used = Math.max(used, (targetCount[i] - 1) / stickersCount[row][i] + 1);
//            }
//        }
//        // save targetCount
//        for (int i = 0; i < stickersCount[row].length; i++) {
//            targetCount[i] -= used * stickersCount[row][i];
//        }
//        search(ans + used, row + 1);
//    }


    public int minStickers(String[] stickers, String target) {
        int N = target.length();
        // The power of 2
        int[] dp = new int[1 << N];
        for (int i = 1; i < 1 << N; i++) {
            dp[i] = -1;
        }
        for (int state = 0; state < 1 << N; state++) {
            if (dp[state] == -1) {
                continue;
            }
            for (String sticker : stickers) {
                int now = state;
                for (char letter : sticker.toCharArray()) {
                    for (int i = 0; i < N; i++) {
                        if (((now >> i) & 1) == 1) {
                            continue;
                        }
                        if (target.charAt(i) == letter) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << N) - 1];
    }

    public static void main(String[] args) {
        SixNineOne sixNineOne = new SixNineOne();
        sixNineOne.minStickers(new String[]{"with", "example", "science"}, "thehat");
    }
}
