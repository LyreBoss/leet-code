package com.share.solution.difficulty.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数
 * ，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author Lgq create on 2020/9/6
 */
public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //gen("", result, n, n);

        _gen(0, 0, n, "", result);
        return result;
    }

    private void gen(String subString, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {

            result.add(subString);
            return;
        }
        if (left > 0) {
            gen(subString + "(", result, left - 1, right);
        }
        if (right > left) {
            gen(subString + ")", result, left, right - 1);
        }
    }

    private void _gen(int left, int right, int n, String subString, List<String> result) {
        if (left == n && right == n) {
            result.add(subString);
            System.out.println(subString);
            return;
        }

        if (left < n) {

            _gen(left + 1, right, n, subString + "(", result);
        }
        if (left > right && right < n) {
            _gen(left, right + 1, n, subString + ")", result);
        }
    }

    public int[] exchange(int[] nums) {
        int len = nums.length;
        if (nums == null || len <= 2) {
            return nums;
        }
        // 冒泡的变种
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] % 2 == 0) {
                continue;
            } else {
                int ti = i;
                while (ti < len - 1) {

                    int temp = nums[ti];
                    nums[ti] = nums[ti + 1];
                    nums[ti + 1] = temp;
                    ti++;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        for (int i : generateParenthesis.exchange(nums)) {

            System.out.println(i);
        }
        System.out.println();
    }
}
