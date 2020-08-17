package com.share.solution.difficulty.one;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author Lgq create on 2020/8/17
 */
public class ContainsDuplicate {


    public boolean containsDuplicate(int[] nums) {

        if (nums.length == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            set.add(num);
        }



        Map<Integer,Integer> map = new HashMap<>();
        int tmp = 1 ;
        for(int i = 0; i < nums.length ; i++){

            if(map.get(nums[i]) ==null){
                map.put(nums[i],tmp);
                tmp = nums[i];
            }else{
                map.remove(nums[i]);
            }
        }

    }


        return set.size() < nums.length;
    }
}
