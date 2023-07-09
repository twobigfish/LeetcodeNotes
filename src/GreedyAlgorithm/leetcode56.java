package GreedyAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: Dayuu
 * @description: 合并区间
 */
public class leetcode56 {
    // 自己写的
    // 先更新 然后放入结果集中
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> {
            //return a[0] - b[0];
            return Integer.compare(a[0], b[0]);
        });
        LinkedList<int[]> ans = new LinkedList<>(); // 存结果
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else {
                ans.add(intervals[i - 1]);
            }
            if (i == intervals.length - 1) {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }


    // 代码随想录
    // 先放入结果集中，然后取出进行判断更新
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
            //return Integer.compare(a[0], b[0]);
        });
        LinkedList<int[]> ans = new LinkedList<>(); // 存结果
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.getLast()[1]) {
                int start = ans.getLast()[0];
                int end = Math.max(intervals[i][1], ans.getLast()[1]);
                ans.removeLast();
                ans.add(new int[]{start, end});
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
