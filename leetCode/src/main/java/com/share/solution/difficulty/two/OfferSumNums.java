package com.share.solution.difficulty.two;

/**
 * 剑指 Offer 64. 求1+2+…+n
 *
 * @author Lgq create on 2020/8/16
 */
public class OfferSumNums {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
