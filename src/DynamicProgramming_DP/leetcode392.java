package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 392.判断子序列
 */
public class leetcode392 {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 初始化

        // t是否包含s => t>=s
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //和 1143.最长公共子序列的递推公式基本那就是一样的，
                    // 区别就是 本题如果删元素一定是字符串t，而 1143.最长公共子序列 是两个字符串都可以删元素。
                    dp[i][j] = dp[i][j - 1]; // 相当于t要删除元素，继续匹配
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
