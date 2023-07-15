package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 213.打家劫舍II
 */
public class leetcode213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = rob1(nums, 0, nums.length - 2);
        int j = rob1(nums, 1, nums.length - 1);
        return Math.max(i, j);
    }

    // [left, right] 包含边界
    public int rob1(int[] nums, int left, int right) {
        if (left == right) return nums[left]; // 相当于 nums[left, right].length = 1

        int[] dp = new int[nums.length]; // left和right是nums数组的下标，所以dp.length=nums.length
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);

        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[right];
    }
}
