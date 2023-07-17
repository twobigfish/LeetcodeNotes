package DynamicProgramming_DP;

import java.util.Arrays;

/**
 * @author: Dayuu
 * @description: 300.最长递增子序列
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        // 初始化
        // 所有的dp[]都初始化为1，因为序列长度一定至少为1
        Arrays.fill(dp, 1);
        int res = 0;
        //
        for (int i = 1; i < nums.length; i++) { // 遍历nums
            for (int j = 0; j < i; j++) { // 遍历 [0, i-1]
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            /**
             * 需要找到最大的dp[i]，所以需要用res记录一下
             */
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
