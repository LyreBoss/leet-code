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


    public int[] searchRange(int[] nums, int target) {
        if (nums == nums) return new int[]{-1, -1};
        int len = nums.length;
        if (len == 1 && target != nums[0]) {
            return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};
        int begin = 0;
        int end = len - 1;
        while (isF(begin, end)) {
            if (nums[begin] == target && res[0] == -1) {
                res[0] = nums[begin];
            }
            if (nums[end] == target && res[1] == -1) {
                res[1] = nums[end];
            }
            begin++;
            end--;
        }
        return res;
    }

    private boolean isF(int begin, int end) {
        return begin <= end ? true : false;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        //

        //generateParenthesis.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        //int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        //for (int i : generateParenthesis.exchange(nums)) {
        //
        //    System.out.println(i);
        //}
        //System.out.println();

        //int[][] nums = new int[][]{{0, 1}, {1, 1}};

        //System.out.println(generateParenthesis.oddCells(2, 3, nums));

        System.out.println(2%6);
    }

    public int oddCells(int n, int m, int[][] indices) {
        // 初始化
        int[][] arrs = new int[n][m];

        // 填充
        int row = indices.length;
        int col = indices[0].length;

        for (int i = 0; i < row; i++) {
            int[] tem = indices[i];
            // 行 列
            int h = tem[0];
            int l = tem[1];
            for (int j = 0; j < m; j++) {
                arrs[h][j] = arrs[h][j] + 1;
            }
            for (int k = 0; k < n; k++) {
                arrs[k][l] = arrs[k][l] + 1;
            }
        }

        //统计

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrs[i][j] % 2 != 0) {
                    res += 1;
                }
            }
        }
        return res;
    }



}
