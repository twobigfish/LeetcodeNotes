package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 714.买卖股票的最佳时机含手续费
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        // 初始化
        // 0不持有股票  1持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[dp.length - 1][0];
    }
}
