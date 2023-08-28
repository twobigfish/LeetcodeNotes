package hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * @author dayuu
 * @create 2023/5/6 14:47
 */
public class leetcode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int temp = i + j;
                if (map.containsKey(temp)) {
                    int key = map.get(temp);
                    map.put(temp, ++key);
//                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int temp = -(i + j);
                if (map.containsKey(temp)) {
                    count += map.get(temp); // 加上所有符合条件的数量，而不是++/+1
                }
            }
        }
        return count;
    }
}
