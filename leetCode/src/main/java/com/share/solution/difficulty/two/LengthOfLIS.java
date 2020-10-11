package com.share.solution.difficulty.two;

import java.util.Arrays;
import java.util.Stack;

/**
 * 300. 最长上升子序列
 *
 * @author Lgq create on 2020/10/8
 */
public class LengthOfLIS {


    public int lengthOfLIS(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        int res = 0 ;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);

        }
        return res ;
    }



    //输入: "(*))"

    public boolean checkValidString(String s) {
        if (s == null) {
            return true;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        if (chars[0] == ')') {
            return false;
        } else {
            stack.push(chars[0]);
        }

        for (int i = 1; i < chars.length; i++) {
            Character peek = stack.peek();
            if (peek == '(' || peek == '*' )
                stack.push(chars[i]);


        }
        return false;

    }
}
