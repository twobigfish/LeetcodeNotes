package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 516.最长回文子序列
 * TODO 回文子串是要连续的，回文子序列可不是连续的
 */
public class leetcode516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        // 初始化 i==j时，即1个字符肯定是回文子序列，dp[i][i]=1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) { // 因为j>i，所以j=i+1
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // 新增的两端字符不相等，所以长度不变，等于max(前一个的长度)
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
