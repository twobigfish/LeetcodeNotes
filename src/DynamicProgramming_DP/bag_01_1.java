package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 二维dp数组01背包
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class bag_01_1 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }
    /**
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        // 创建dp数组
        // bagSize + 1: 因为背包容量从0开始算，一直算到 bagSize
        int[][] dp = new int[weight.length][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        // 法1 先遍历物品，后遍历背包
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                /**
                 * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                 * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                 */
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.println(dp[i][j] + '\t');
            }
            System.out.println('\n');
        }
    }
}
