package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 583. 两个字符串的删除操作
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode583 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        // dp[i][0]=i   dp[0][j]=j
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    /**
                     * 若所在位置的元素相同，则不需要删除元素，dp的数值不变
                     */
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /**
                     * 所在位置的元素不相同，则需要删除元素后进行比较，取最小
                     * dp[i - 1][j - 1] + 2 = dp[i][j - 1] + 1 或者 dp[i - 1][j - 1] + 2 = dp[i - 1][j] + 1
                     *
                     */
                    //dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
