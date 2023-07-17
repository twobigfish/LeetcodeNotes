package DynamicProgramming_DP;

import java.util.Arrays;

/**
 * @author: Dayuu
 * @description: 674. 最长连续递增序列
 * 和leetcode300的区别是 连续
 */

/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化
        Arrays.fill(dp, 1);
        int res = 1; // 因为 序列长度 >= 1

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
