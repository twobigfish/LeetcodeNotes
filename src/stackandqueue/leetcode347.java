package stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author dayuu
 * @create 2023/5/13 18:47
 */

class Solution {
    //解法1：基于大顶堆实现
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        /**
         * 1.
         * 参考 https://blog.csdn.net/weixin_45525272/article/details/125833529
         * 小顶堆 Queue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
         * 大顶堆 Queue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
         *
         * 2.
         * 参考 https://www.runoob.com/java/java-hashmap-entryset.html
         * map.entrySet()：HashMap中所有的键值对都被看作是一个 set 集合。
         * 例如[1=Google, 2=Runoob, 3=Taobao]
         * */

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
            /**
             * 3.
             * 参考 https://blog.csdn.net/haohulala/article/details/122125529
             * 每次向大顶堆中放入一个数组，并按照数组中第1个值的大小排序
             */
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {//依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    //解法2：基于小顶堆实现
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> smallqueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (smallqueue.size() < k) { //小顶堆元素个数小于k个时直接加
                smallqueue.add(new int[]{entry.getKey(), entry.getValue()});
            } else if (smallqueue.peek()[1] < entry.getValue()) { //当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                smallqueue.poll();//弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                smallqueue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = smallqueue.poll()[0];
        }
        return ans;
    }
}

public class leetcode347 {
}
