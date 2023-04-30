package array;

/**
 * @author dayuu
 * @create 2023/4/29 23:15
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
}
