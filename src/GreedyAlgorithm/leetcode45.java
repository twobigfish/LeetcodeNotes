package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 跳跃游戏 II
 */
public class leetcode45 {
    public int jump(int[] nums) {
        if (nums.length == 1) { // 只有1个元素，则不需跳跃。
            return 0;
        }
        int currange = 0; // 当前覆盖最远距离下标
        int nextrange = 0; // 下一步覆盖最远距离下标
        int step = 0; // 记录走的最大步数
        for (int i = 0; i < nums.length; i++) {
            nextrange = Math.max(nextrange, i + nums[i]);
            if (currange == i) { // 遇到当前覆盖最远距离下标
                step++;
                currange = nextrange;
                if (currange >= nums.length - 1) {
                    break;
                }
            }
        }
        return step;
    }
}
