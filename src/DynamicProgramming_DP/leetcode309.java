package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 309. 最佳买卖股票时机含冷冻期
 */
public class leetcode309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        // 初始化
        /*
         dp[][0] 持有股票的状态：前一天已经 0持有股票、今天买入且前一天是 3冷冻期、今天买入且前一天 1不持有
         dp[][1] 不持有股票的状态：前一天是 1不持有、前一天是 3冷冻期
         dp[][2] 今天卖出股票：前一天 1持有
         dp[][3] 今天是冷冻期：前一天是 2卖出
         */
        dp[0][0] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[dp.length - 1][1], Math.max(dp[dp.length - 1][2], dp[dp.length - 1][3]));
    }
}
