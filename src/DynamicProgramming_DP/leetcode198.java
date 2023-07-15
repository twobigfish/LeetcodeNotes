package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 198. 打家劫舍
 */
public class leetcode198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // 只有1个房间

        int[] dp = new int[nums.length]; // 考虑 第i个及其之前的房间 所获得的最高金额为dp[i]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        // 注意：本题房间从0开始，dp也是从0开始，所以遍历范围是[0, nums.length-1]
        return dp[nums.length - 1];
    }
}
