package com.share.solution.difficulty.two;

/**
 * 回文字串
 *
 * @author Lgq create on 2020-03-13
 */
public class CountSubstrings {


    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2 * N - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    /**
     * 动态规划
     */
    class Solution {
        public int countSubstrings(String s) {
            int size = s.length();
            char[] ss = s.toCharArray();
            // 初始化
            boolean[][] dp = new boolean[size][size];
            for (int i = 0; i < size; i++) {   // 主对角线，单个字符认为是长度为 1 的回文串
                dp[i][i] = true;
            }
            // 填表并记录结果
            int count = size;   // 至少单个字符都算是回文串
            for (int i = size - 2; i >= 0; i--) {
                for (int j = i + 1; j < size; j++) {
                    if (ss[i] != ss[j]) {
                        dp[i][j] = false;
                    } else if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    // s[i ,j]是回文串吗
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
