package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 斐波那契数
 */
public class leetcode509 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1]; //第n个斐波那契数 相当于数组的第n个数 (0...n) -> 共计n+1
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
