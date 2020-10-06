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

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }


    //回文子串
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && ((i - j <= 2) || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    if (maxLen < i - j + 1) {
                        maxLen = i - j + 1;
                        maxStart = j;
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * aba  一个用多少个 回文子串
     *
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }

        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }


    /**
     * --
     *
     * @param subString -
     * @return -
     */

    public String maxSubString(String subString) {


        if (subString == null || subString.length() <= 1) {
            return subString;
        }
        int len = subString.length();

        int maxLen = 0;
        int startIndex = 0;
        int endIndex = 0;

        boolean[][] dp = new boolean[len][len];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (subString.charAt(i) == subString.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;

                    if (maxLen < i - j + 1) {
                        maxLen = i - j + 1;
                        startIndex = i;
                        endIndex = j;
                    }

                }

            }
        }

        return subString.substring(startIndex, endIndex + 1);
    }
}
