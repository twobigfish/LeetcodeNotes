package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author: Dayuu
 * @description: 用最少数量的箭引爆气球
 */
public class leetcode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] >= b[0] ? 1 : -1;
            // return Integer.compare(a[0], b[0]);
        });
        int count = 1; // 至少1个气球 => 至少需要1只箭
        for (int i = 1; i < points.length; i++) {
            // 气球i的左边界 <= 气球i-1的右边界
            if (points[i][0] <= points[i - 1][1]) { // 气球i和气球i-1 挨着
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            } else { // 气球i和气球i-1 不挨着
                count++;
            }
        }
        return count;
    }
}
