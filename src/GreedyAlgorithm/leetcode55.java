package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 跳跃游戏
 */
public class leetcode55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverange; i++) {
            coverange = Math.max(coverange, i + nums[i]);
            if (coverange >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
