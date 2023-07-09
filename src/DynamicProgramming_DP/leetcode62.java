package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 不同路径
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组

     * 1. 确定dp数组下标含义 dp[i][j] 到每一个坐标可能的路径种类
     * 2. 递推公式 dp[i][j] = dp[i-1][j] dp[i][j-1]
     * 3. 初始化 dp[i][0]=1 dp[0][i]=1 初始化横竖就可
     * 4. 遍历顺序 一行一行遍历
     * 5. 推导结果
 */
public class leetcode62 {
    public int uniquePaths(int m, int n) {
        // m行 n列
        int[][] dp = new int[m][n];
        // 3.初始化dp数组
        // 第0行的有1个路径
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 第0列的有1个路径
        for (int j = 0; j < m; j++) {
            dp[j][0] = 1;
        }
        // 4.遍历 m行 n列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
