package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: LeetCode：647.回文子串
 */
public class leetcode647 {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        // 初始化 0表示不是回文串 1表示是回文串
        int res = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) { // j=i：为了从单个字符开始，向两边扩展进行判断
                if (s.charAt(i) == s.charAt(j)) { // 不想等就不是回文串，设置为0（因为是初始化的值，所以不需要操作）
                    if (j - i <= 1) { // 如果i和j是相邻字符 或者 是同一个字符
                        dp[i][j] = 1;
                        res++;
                    } else if (dp[i + 1][j - 1] == 1) { // 至少3个字符进行判断
                        dp[i][j] = 1;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
