package com.share.solution.difficulty.two;

/**
 * 最大子序和
 * 经典
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author Lgq create on 2020/8/13
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int dp[] = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};


        MaxSubArray subArray = new MaxSubArray();

        System.out.println(subArray.maxSubArray(nums));
    }
}
