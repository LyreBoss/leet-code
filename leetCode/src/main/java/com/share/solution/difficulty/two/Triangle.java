package com.share.solution.difficulty.two;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author Lgq create on 2020/7/5
 */
public class Triangle {

    public static void main1(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(3);
        list3.add(8);
        triangle.add(list3);

        minimumTotal(triangle);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        for (int i : dp) {
            System.out.print(i + "---");
        }
        return dp[0];
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int up = 0, left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;

        // 相撞
        while (avoid(left, right, up, down)) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[left][i]);
            }
            up++;
            for (int j = up; j <= down; j++) {
                res.add(matrix[j][right]);
            }
            right--;
            if (avoid(left, right, up, down)) {
                for (int k = right; k >= left; k--) {
                    res.add(matrix[down][k]);
                }
                for (int l = down - 1; l >= up; l--) {
                    res.add(matrix[l][left]);
                }
            }
            down--;
            left++;
        }

        return res;
    }

    private boolean avoid(int left, int right, int up, int down) {
        return up <= down && left <= right;
    }


    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 1) {
            return true;
        }

        dfs(postorder, 0, postorder.length);

        return true;
    }

    private void dfs(int[] postorder, int start, int len) {

    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 2},
                {5, 6}};

        new Triangle().spiralOrder(test);
    }
}
