package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 摆动序列
 */
public class leetcode376 {
    public int wiggleMaxLength(int[] nums) {
        int predif = 0; // 上一个差值
        int curdif = 0; // 当前差值
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            curdif = nums[i] - nums[i - 1];
            if ((predif >= 0 && curdif < 0) || (predif <= 0 && curdif > 0)){
                res++;
                predif = curdif;
            }
        }
        return res;
    }
}
