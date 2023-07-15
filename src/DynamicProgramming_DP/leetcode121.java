package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 121. 买卖股票的最佳时机
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode121 {
    // 法 1 贪心
    // 因为股票就买卖一次，那么贪心的想法很自然就是取最左最小值，取最右最大值，那么得到的差值就是最大利润。
    public int maxProfit1(int[] prices) {
        int low = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]); // 找到左边最小的值
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }

    // 法 2
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
            // 题目规定 一只股票只能买卖一次，所以第i天买入后的现金是 0 - prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
        }
        return dp[dp.length - 1][0];
    }
}
