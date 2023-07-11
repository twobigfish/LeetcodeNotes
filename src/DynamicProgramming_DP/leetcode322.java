package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 322. 零钱兑换
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化
        // 初始化dp数组为最大值
        for (int j = 1; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        // 当金额为0时需要的硬币数目为0
        dp[0] = 0;
        // 先物品（从第一个物品开始，例如：数组从下标0开始，数值从1开始） 后背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要  比如：coins[2] target=3 凑不出3
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
