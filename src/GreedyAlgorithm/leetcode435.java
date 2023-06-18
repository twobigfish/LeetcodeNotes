package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author: Dayuu
 * @description: 无重叠区间
 */
public class leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0]; // 按照区间的左边界升序排序
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 重叠 区间i的左边界 < 区间i-1的右边界
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return count; // 按照区间的左边界升序排序 => 重叠区间个数，即需要移除区间的最小数量。
    }
}
