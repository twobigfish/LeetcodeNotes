package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author: Dayuu
 * @description: 分发饼干
 */
public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // 胃口 i
        Arrays.sort(s); // 饼干 j

        int j = s.length - 1; // 饼干的数组的下标
        int res = 0;
        for (int i = g.length - 1; i >= 0; i--) { // 遍历胃口
            if (j >= 0 && s[j] >= g[i]) {   // 遍历饼干
                j--;
                res++;
            }
        }
        return res;
    }
}
