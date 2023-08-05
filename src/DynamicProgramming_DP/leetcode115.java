package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 115.不同的子序列
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // dp[0][0]=1
        // dp[i][0]=1
        // dp[0][j]=0
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    /**
                     * 当s[i-1]==t[j-1]时，即当前遍历的元素相等，则只需要看前一个元素的结果（上一个状态）
                     *   1.使用s[i-1]，对应的结果为dp[i - 1][j - 1]
                     *   2.不使用s[i-1]，判断s[i-2]是否满足相等，即dp[i-1][j]
                     */
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 当s[i-1]!=t[j-1]时，当前元素不计数（删除），总数不变，即dp[i-1][j]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
