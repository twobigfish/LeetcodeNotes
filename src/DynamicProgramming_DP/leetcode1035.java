package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 1035. 不相交的线
 */
public class leetcode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // 初始化 dp所有元素初始化为0

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 可以不连续 => 当前元素不相等时，停止+1，使用上一个位置的元素
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
