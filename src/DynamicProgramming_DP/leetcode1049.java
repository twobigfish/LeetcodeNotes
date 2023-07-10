package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 1049.最后一块石头的重量II
 */

/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
 */
public class leetcode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int[] bag = new int[sum / 2 + 1]; // 记住要 +1
        for (int i = 0; i < stones.length; i++) {  // 物品是从第0个开始 而背包是从第1个开始，因为bag[j]中的j表示背包的容量
            for (int j = bag.length - 1; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                bag[j] = Math.max(bag[j], bag[j - stones[i]] + stones[i]);
            }
        }
        return (sum - bag[bag.length - 1]) - bag[bag.length - 1];
    }
}
