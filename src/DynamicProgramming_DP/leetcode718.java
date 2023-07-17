package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 718. 最长重复子数组
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // 初始化
        /*
        dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
        所以： 1. dp[i][j] = 0;
             2. 不包括边界 =>    dp长度为[nums1.length + 1][nums2.length + 1]
        */
        int res = 0;

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]); // 记录最大值
            }
        }
        return res;
    }
}
