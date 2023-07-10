package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 518.零钱兑换II
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
// 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
// 如果求排列数就是外层for遍历背包，内层for循环遍历物品
public class leetcode518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // 凑成总金额j的货币组合数为dp[j]
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1; //初始化
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
