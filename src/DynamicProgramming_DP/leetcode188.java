package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 188. 买卖股票的最佳时机 IV
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        // 初始化
        /*
         j的状态表示为：
            0 表示不操作
            1 第一次买入
            2 第一次卖出
            3 第二次买入
            4 第二次卖出
        */
        // dp[0][0] 第0天不操作 j为偶数 0
        // dp[0][1] 第0天第1次买入 j为奇数 -prices[i]
        // dp[0][2] 第0天第1次卖出 j为偶数 0
        for (int j = 1; j < 2 * k + 1; j = j + 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j = j + 2) {  //  计算过程有j+2，所以遍历范围=实际范围-2
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}

