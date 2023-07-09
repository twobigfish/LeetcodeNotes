package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 一维dp数组（滚动数组）
 */
public class bag_01_2 {
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        // 定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        // 遍历顺序： 先遍历物品，再遍历背包，且背包倒序遍历
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
    }
}
