package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 377. 组合总和 Ⅳ
 * TODO 如果本题要把排列都列出来的话，只能使用回溯算法暴力搜。
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
// 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
// 如果求排列数就是外层for遍历背包，内层for循环遍历物品
public class leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1]; // 组成 目标和j 的 “排列” 个数有dp[j]个
        dp[0] = 1; // 初始化 为了推导递推公式

        // 先背包 后物品
        for (int i = 0; i <= target; i++) { // 背包
            for (int j = 0; j < nums.length; j++) { //物品
                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
