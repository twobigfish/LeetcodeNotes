package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/solutions/2349891/javapython3mo-ni-zhu-yi-bian-jie-tu-jie-k787e/
 */
public class leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix[0].length; // 长，即列的数量
        int m = matrix.length; // 宽，即行的数量
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while (up <= down && left <= right) {
            // 从左到右
            for (int j = left; j <= right; j++) {
                list.add(matrix[up][j]);
            }

            //从上到下
            for (int i = up + 1; i <= down; i++) {
                list.add(matrix[i][right]);
            }

            // 如果此时上下边界重合（单行）或左右边界重合（单列），无需再遍历，否则重复。
            if(up == down || left == right) {
                break;
            }

            //从右到左
            for (int j = right - 1; j >= left; j--) {
                list.add(matrix[down][j]);
            }

            //从下到上
            for (int i = down - 1; i > up; i--) {
                list.add(matrix[i][left]);
            }
            up = up + 1;
            down = down - 1;
            left = left + 1;
            right = right - 1;
        }
        return list;
    }
}
