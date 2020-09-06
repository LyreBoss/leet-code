package com.share.solution.difficulty.two;

/**
 * @author Lgq create on 2020-04-02
 */
public class CanJump {

    public boolean canJump(int[] nums) {

        if (nums.length == 1 && nums[0] > 1) {
            return true;
        } else if (nums[0] == 0) {
            return false;
        }
        int len = nums.length;

        //初始位置
        int i = 0;
        //下一个
        int j = 0;

        while (j < len) {


            j++;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=======" + Integer.MAX_VALUE);
    }
}
