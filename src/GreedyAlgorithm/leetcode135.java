package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 分发糖果
 */

/**
 分两个阶段
 1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
 2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大） 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
 */
public class leetcode135 {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) { // 右大于左
                candyVec[i] = candyVec[i - 1] + 1;
            } else {
                candyVec[i] = 1;
            }
        }
        int sum = candyVec[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) { // 左大于右
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
            sum += candyVec[i];
        }
        return sum;
    }
}
