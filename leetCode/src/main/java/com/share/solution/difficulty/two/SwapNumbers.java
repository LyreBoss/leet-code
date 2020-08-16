package com.share.solution.difficulty.two;

/**
 * 面试题 16.01. 交换数字
 *
 * @author Lgq create on 2020/8/16
 */
public class SwapNumbers {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[0] + numbers[1];
        numbers[0] = numbers[1] - numbers[0];
        return numbers;
    }
}
