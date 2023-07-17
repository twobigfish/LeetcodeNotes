package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 122.买卖股票的最佳时机II
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode122 {
    public int maxProfit(int[] prices) {
        //dp[i][0] 表示第i天不持有股票所得最多现金
        //dp[i][1] 表示第i天持有股票所得最多现金
        int[][] dp = new int[prices.length][2];
        // 初始化  0表示不持有股票，1表示持有股票
        // 第 dp[0]天 是指 第 1 天
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            // 不持有股票  max(第i-1天就不持有股票， 第i天卖出股票 => 所得现金就是按照今天股票价格卖出后所得现金)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持有股票   max(第i-1天就持有股票， 第i天买入股票 => 所得现金就是买入今天的股票后所得现金)
            // TODO 题目规定 一只股票可以买卖多次 和 leetcode121 唯一不一样的地方
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //本题中不持有股票状态所得金钱一定比持有股票状态得到的多
        return dp[dp.length - 1][0];
    }
}
