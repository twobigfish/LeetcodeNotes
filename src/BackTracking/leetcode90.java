package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 子集II
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
public class leetcode90 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used, false); // 默认都为false
        backtracing(nums, 0);
        return res;
    }
    /**
     * leetcode40,47,90
     * 40：组合（有重复元素->需要Arrays.sort）   无序  需要startIndex
     * 47：排列（有重复元素->需要Arrays.sort）   有序  不需要startIndex，每次回溯都是从i=0开始，也因此排列问题必然需要一个used来判断同一树枝中是否使用过当前元素
     * 90：子集（有重复元素->需要Arrays.sort）   无序  需要startIndex
     */
    void backtracing(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex > nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 我们要对同一树层使用过的元素进行跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtracing(nums, i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
        }

    }
}
