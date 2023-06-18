package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: Dayuu
 * @description: 根据身高重建队列
 */

// java中的Arrays.sort()的几种用法 https://blog.csdn.net/weixin_47872288/article/details/116721995
// 比较器的用法 https://blog.csdn.net/m0_54185237/article/details/126431700
public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            // a - b（左 - 右） 是升序排序
            if (a[0] == b[0]) { // 当第一个元素（身高）相同时，则比较第二个元素
                return a[1] - b[1];
            }
            // b - a（右 - 左） 是降序排序
            return b[0] - a[0];
        });

        // 使用队列，插入元素更快
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            queue.add(p[1], p); // 把元素p（h,k）插入到位置k
        }
        // toArray()方法使用说明  https://blog.csdn.net/guomutian911/article/details/45788707
        return queue.toArray(new int[people.length][]);
    }
}
