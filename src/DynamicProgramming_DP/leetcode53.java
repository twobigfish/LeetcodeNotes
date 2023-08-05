package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 53. 最大子数组和
 */
public class leetcode53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 法1
            res = Math.max(dp[i], res);
            // 法2
            /*if (dp[i] > res) {
                res = dp[i];
            }*/
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int count = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            // 先记录最大值，因为count=0可能会使结果错误
            if (count > res) { // 记录res最大值
                res = count;
            }
            if (count < 0) { // 如果累加和小于0，则从下一个元素重新计算
                count = 0;
            }
        }
        return res;
    }
}
