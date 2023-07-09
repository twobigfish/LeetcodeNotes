package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 单调递增的数字
 */
public class leetcode738 {
    public int monotoneIncreasingDigits(int n) {
        /**
         * 把非字符串类型的值转为String字符串类型
         * 参考 https://blog.csdn.net/weixin_45987961/article/details/121843047
         * 1. String.valueOf()  推荐使用 基本类型也可以使用
         * 2. toString() 基本类型（如int）无法使用，封装类型（Integer）才可以
         * 3. (String) 强转
         */
        String s = String.valueOf(n); // int -> string
        char[] array = s.toCharArray(); // string -> char[]
        int flag = array.length;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] > array[i]) {
                flag = i;
                array[i - 1]--;
            }
        }
        // 避免特殊情况 100 -> 99
        for (int i = flag; i < array.length; i++) {
            array[i] = '9';
        }
        // Integer.parseInt 作用是将()内的String类型字符串转化为int类型
        return Integer.parseInt(String.valueOf(array));
    }
}
