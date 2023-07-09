package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 使用最小花费爬楼梯
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        // 到达第i台阶所花费的最少体力为dp[i]
        int[] dp = new int[cost.length + 1];  // 因为要求是到达楼梯顶部，所以dp数组的大小是cost数组的长度+1
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
