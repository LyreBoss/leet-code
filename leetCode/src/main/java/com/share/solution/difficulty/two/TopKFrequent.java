package com.share.solution.difficulty.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 347. 前 K 个高频元素
 *
 * @author Lgq create on 2020/10/8
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int[] tong = new int[nums.length + 1];
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            tong[value] = key;
        }
        int[] res = new int[k];
        for (int i = tong.length - 1; i >= 0 && k >= 0; i--) {
            if (tong[i] == 0) {
                continue;
            }
            res[k - 1] = tong[i];
            k = k - 1;
            if (k == 0) {
                break;
            }
        }

        return res;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 1) {
            return 10;
        }
        if (n == 2) {
            return 91;
        }
        int temp = 1;
        while (n > 0) {
            temp = temp * 10;
            n--;
        }
        int res = temp - 1;
        List<Integer> in = new ArrayList<>();
        while (temp >= 10) {
            int a = temp % 10;
            int b = temp / 10;
            in.add(a);

            while (b > 10) {
                a = b % 10 ;
                b = b / 10 ;
                if (in.contains(a) || a == b) {
                    res--;
                    break;
                }
                in.add(a);
            }
            temp --;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequent().countNumbersWithUniqueDigits(3));
        System.out.println(9/10);

    }
}
