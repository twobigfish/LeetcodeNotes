package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dayuu
 * @create 2023/4/29 22:07
 */
public class leetcode904 {
//    参考：https://pic.leetcode.cn/1676554659-UJbbDS-image.png
    public int totalFruit(int[] fruits) {
        // 建立哈希表 int int 类型
        HashMap<Integer, Integer> fruitshashMap = new HashMap<>();
        int left = 0, result = 0;
        for (int right = 0; right < fruits.length; right++) {
            // 用哈希表存储 该窗口内的数及其出现的次数
            fruitshashMap.put(fruits[right], fruitshashMap.getOrDefault(fruits[right], 0) + 1);
            // 如果出现了第三种 数字，则右移左边界，直到满足条件
            while (fruitshashMap.size() > 2) {
                fruitshashMap.put(fruits[left], fruitshashMap.get(fruits[left]) - 1);
                if (fruitshashMap.get(fruits[left]) == 0) {
                    fruitshashMap.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1); // 每次右移右边界都会更新窗口的长度
        }
        return result;
    }
}
