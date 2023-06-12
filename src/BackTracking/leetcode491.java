package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Dayuu
 * @description: 递增子序列
 */

/* 模板
void backtracking(参数){
    if(终止条件){
        存放结果;
        return;
    }

    for(选择：本层集合中元素（树中节点孩子的数量就是集合的大小）){
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}
*/
public class leetcode491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracting(nums, 0);
        return res;
    }

    void backtracting(int[] nums, int startIndex) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        //if (startIndex > nums.length) { // 不加也行，startIndex会在for中判断
        //    return;
        //}
        // 判断每一层中是否用过相同的数字（对应数值），和每一层中是否用过同一个数（对应位置）不一样
        Map<Integer, Integer> used = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (used.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]) {
                continue;
            }
            used.put(nums[i], used.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            backtracting(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
