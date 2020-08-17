package com.share.solution.difficulty.one;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author Lgq create on 2020/8/17
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;

        int tmp = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i+1]){
                continue;
            }
            tmp += 1;
        }

        return tmp;
    }
}
