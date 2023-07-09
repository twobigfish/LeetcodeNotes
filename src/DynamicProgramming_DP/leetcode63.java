package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 不同路径 II
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // 行
        int n = obstacleGrid[0].length; // 列
        int[][] dp = new int[m][n];


        // 初始化 第0行
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        // 初始化 第0列
        for (int j = 0; j < m && obstacleGrid[j][0] == 0; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }

        return dp[m - 1][n - 1];
    }
}
