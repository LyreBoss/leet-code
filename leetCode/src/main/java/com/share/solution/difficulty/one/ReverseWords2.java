package com.share.solution.difficulty.one;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * @author Lgq create on 2020/9/9
 */
public class ReverseWords2 {


    public String reverseWords(String s) {

        if (s == null) {
            return null;
        }
        String[] split = s.split(" ");
        // 只有一个 去除空格
        if (split.length == 1) {
            return split[0];
        }
        //翻转
        int start = 0;
        int end = split.length - 1;
        while (start < end) {
            String temp = split[start];
            split[start] = split[end];
            split[end] = temp;
            start++;
            end--;

        }
        StringBuilder builder = new StringBuilder();

        for (String value : split) {
            if (value.equals("")) {
                continue;
            }
            builder.append(value).append(" ");
        }
        return builder.toString().trim();
    }


    public static void main(String[] args) {
        String str = "   hello  world!   ";


        ReverseWords2 words2 = new ReverseWords2();
        String s = words2.reverseWords(str);

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        System.out.println(s);
    }

    public int missingNumber(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return nums[0] == 1 ? 0 : 1;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += i - nums[i];
        }
        return res > 0 ? (len - res) : (len + res);
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int slen = staple.length;
        int dlen = drinks.length;
        int count = 0;

        Arrays.sort(staple);
        Arrays.sort(drinks);

        Arrays.fill(staple, 1);
        for (int i = 0; i < slen; i++) {
            for (int j = dlen - 1; j >= 0; j--) {
                if (staple[i] + drinks[j] <= x) {
                    count += count * j;
                }

            }
        }

        return count > 1000000008 ? 1 : count;
    }


    public int minimumOperations(String leaves) {
        int result[] = new int[4];
        int dpNext[] = new int[4];
        int max = (int) 1e8;
        Arrays.fill(result, max);
        result[0] = 0;
        for (char c : leaves.toCharArray()) {
            Arrays.fill(dpNext, max);
            dpNext[1] = Math.min(result[1] + cost('r', c), result[0] + cost('r', c));
            dpNext[2] = Math.min(result[2] + cost('y', c), result[1] + cost('y', c));
            dpNext[3] = Math.min(result[3] + cost('y', c), result[3] + cost('y', c));

            int[] temp = result;
            result = dpNext;
            dpNext = temp;
        }
        return result[3];
    }

    public int cost(char a, char b) {
        return a == b ? 0 : 1;
    }
}
