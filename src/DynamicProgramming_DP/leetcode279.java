package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 279.完全平方数
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 装满容量为j的背包 最少有dp[j]个数
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 先物品（从第一个物品开始，例如：数组从下标0开始，数值从1开始） 后背包
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
