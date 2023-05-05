package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dayuu
 * @create 2023/5/5 20:10
 */
public class leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        // hashSet是Set接口的实现类
        // 使用数组来做哈希的题目，是因为题目都限制了数值的大小。
        // 这道题目刚开始的时候没有规定的数值的范围
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        // 遍历数据nums1，把数据放入set1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组nums2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        // 方法1 新特性
//        return set2.stream().mapToInt(x -> x).toArray();
        // 方法2
        int arr[] = new int[set2.size()];
        int j = 0;
        for (int i : set2) {
            arr[j++] = i;
        }
        return arr;
    }
}
