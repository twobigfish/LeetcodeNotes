package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author: Dayuu
 * @description: K次取反后最大化的数组和
 */
public class leetcode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        while (k-- > 0) { // 每次反转最小值
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }

        int sum = 0;
        for (int i :
                nums) {
            sum += i;
        }
        return sum;
    }
}
