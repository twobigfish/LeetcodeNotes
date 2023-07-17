package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 123.买卖股票的最佳时机III
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        // 初始化
        /**
         * 1 第一次持有股票
         * 2 第一次不持有股票
         * 3 第二次持有股票
         * 4 第二次不持有股票
         */
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 第i-1天已经持有股票；第i天第一次买入股票
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
            // 第i-1天已经不持有股票；第i天第一次卖出股票
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 第i-1天已经第2次持有；第i天第二次持有
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            // 第i-1天已经第2次不持有；第i天第二次不持有
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[dp.length - 1][4];
    }
}
