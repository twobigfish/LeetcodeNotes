package hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * @author dayuu
 * @create 2023/5/5 20:53
 * 再来看一下使用数组和set来做哈希法的局限。
 * <p>
 * 数组的大小是受限制的，而且如果元素很少，而哈希值太大会造成内存空间的浪费。
 * set是一个集合，里面放的元素只能是一个key，而两数之和这道题目，不仅要判断y是否存在而且还要记录y的下标位置，因为要返回x 和 y的下标。所以set 也不能用。
 * 此时就要选择另一种数据结构：map ，map是一种key value的存储结构，可以用key保存数值，用value在保存数值所在的下标。
 */
public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        // 方法1
/*        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i]; // 遍历当前元素，并在map中寻找是否有匹配的key
            if (map.containsKey(tmp)) {
                // 因为先找后插入的方式，结果的顺序会相反（虽然本题没有要求顺序）
                result[1] = i; // 防止重复元素的情况[3,3] 6
                result[0] = map.get(tmp);
                break;
            }
            // 如果没找到匹配对，就把访问过的元素和下标加入到map中
            // 为什么不在前面单独使用一个for循环把nums中的数据放入map？
            // 因为数组中同一个元素在答案里不能重复出现
            map.put(nums[i], i);
        }*/

        // 方法2
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i]; // 遍历当前元素，并在map中寻找是否有匹配的key
            if (map.containsKey(tmp) && i != map.get(tmp)) {
                result[1] = i;
                result[0] = map.get(tmp);
                break;
            }
        }
        return result;
    }
}
