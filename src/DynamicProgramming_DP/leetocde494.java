package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 494.目标和
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetocde494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //如果target过大 sum将无法满足
        if (target < 0 && (sum + target) < 0) {
            return 0;
        }
        // 如果相加为奇数，则无法满足
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int x = (sum + target) / 2;
        if (x < 0) {
            x = -x;
        }
        int[] dp = new int[x + 1];
        dp[0] = 1; //初始化
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
                /**
                 * 为什么要累加上一个dp[j]？
                 * 题目转化为：在集合nums中找出和为left的组合
                 */
            }
        }
        return dp[dp.length - 1];
    }
}
