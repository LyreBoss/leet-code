package com.share.solution.difficulty.two;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * @author Lgq create on 2020/7/10
 */
public class MaxProfit {


    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 0：持有现金
        // 1：持有股票
        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        }
        return dp[len-1][0];


    }


    public int maxProfit1(int[] prices) {

        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0 ;
        }
        if (prices.length == 2) {
            return prices[1] > prices[0]?prices[1] - prices[0] : 0 ;
        }
        int[][] dp = new int[prices.length][3] ;

        dp[0][0] = 0 ; // 没有持有股票
        dp[0][1] = -prices[0] ; //持有一股股票
        dp[0][2] = 0 ;// 卖了一股
        int res = 0 ;
        for (int i = 1 ; i < prices.length ; i ++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1] ,dp[i-1][0] - prices[i]) ;
            dp[i][2] = dp[i-1][1] + prices[i];
            res = Math.max( Math.max(dp[i][0],res),dp[i][0]);
        }
        return res ;
    }


    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit1(new int[]{7,1,5,3,6,4}));
    }
}
