package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 分割等和子集
 */

/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if (sum % 2 != 0) {
            return false;
        }
        // dp[j]表示 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]

        int[] dp = new int[sum / 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // 如果dp[j] == j,则满足
            if (dp[sum / 2] == (sum / 2)) {
                return true;
            }
        }
        return false;
    }
}
