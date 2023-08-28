package hashtable;

import java.util.PriorityQueue;

/**
 * @author: Dayuu
 * @description: 215. 数组中的第K个最大元素
 */
//https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/19607/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
public class leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(); // 优先队列：小顶堆
        for (int num : nums) {
            que.offer(num);
            // 维护一个大小为k的最小堆，堆顶元素就是第k个最大元素
            if (que.size() > k) {
                que.poll();
            }
        }
        return que.peek();
    }
}
