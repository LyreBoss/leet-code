package com.share.solution.difficulty.one;

import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * 思路： 拿到x的倒叙 然后比较
 *
 * @author Lgq create on 2019/11/21
 **/
public class IsPalindrome {
    private static final sun.misc.Unsafe UNSAFE = null;
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;

    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public static void main(String[] args) {
        System.out.println("==>" + isPalindrome(1000));
        System.out.println("==>" + isPalindrome(1001));
        System.out.println("==>" + isPalindrome2(1101));
    }
}
