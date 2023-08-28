package array;

/**
 * @author dayuu
 * @create 2023/4/29 23:15
 * 59.螺旋矩阵II
 */
public class leetcode59 {
    public int[][] generateMatrix(int n) {
        int loop = 0; // 控制循环次数
        int[][] result = new int[n][n];
        int start = 0; // 每次循环的开始点(start, start)
        int count = 1; // 填充的数字
        int i, j;

        while (loop++ < (n >> 1)) {
            // 模拟上侧从左到右  二维数组的第0行
            for (j = start; j < n - loop; j++) {
                result[start][j] = count++; // 每一圈都是从start开始
            }
            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                result[i][j] = count++;
            }
            // 模拟下侧从右到左
            for (; j >= loop; j--) {  // 左闭右开
                result[i][j] = count++;
            }
            // 模拟左侧从下到上
            for (; i >= loop; i--) {  // 左闭右开
                result[i][j] = count++;
            }
            // 更新下一圈开始的位置
            start++;
        }

        // 如果n是基数，则手动在中间位置赋值
        if (n % 2 == 1){
            result[start][start] = count;
        }
        return result;
    }

    // 更好理解
    //https://leetcode.cn/problems/spiral-matrix-ii/solutions/12594/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
    public int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;

        while (up <= down && left <= right) {
            for (int j = left; j <= right; j++) {
                res[up][j] = num++;
            }
            up++;

            for (int i = up; i <= down; i++) {
                res[i][right] = num++;
            }
            right--;

            /*if (up > down || left > right) {
                break;
            }*/

            for (int j = right; j >= left; j--) {
                res[down][j] = num++;
            }
            down--;

            for (int i = down; i >= up; i--) {
                res[i][left] = num++;
            }
            left++;

        }

        return res;
    }
}
