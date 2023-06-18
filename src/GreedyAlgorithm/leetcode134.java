package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 加油站
 */
public class leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cursum = 0;
        int totalsum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            cursum += gas[i] - cost[i];
            totalsum += gas[i] - cost[i];
            if (cursum < 0) {  // 当前累加rest[i]和 curSum一旦小于0
                cursum = 0;    // curSum重新从0开始
                index = i + 1; // 起始位置更新为i+1
            }
        }

        if (totalsum < 0) { // 说明怎么走都不可能跑一圈了
            return -1;
        }
        return index;
    }
}
