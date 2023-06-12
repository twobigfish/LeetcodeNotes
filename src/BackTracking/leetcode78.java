package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 子集
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
public class leetcode78 {
    List<List<Integer>> res = new ArrayList<>(); // 存放符合条件结果的集合
    List<Integer> path = new ArrayList<>();// 用来存放符合条件结果

    public List<List<Integer>> subsets(int[] nums) {
        backtracting(nums, 0);
        return res;
    }
    /**
     * leetcode46,77,78
     * 77:组合（无重复元素）   无序  需要startIndex
     * 46:排列（无重复元素）   有序  不需要startIndex，每次回溯都是从i=0开始，也因此排列问题必然需要一个used来判断同一树枝中是否使用过当前元素
     * 78:子集（无重复元素）   无序  需要startIndex
     */
    void backtracting(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path)); // 「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex > nums.length) { //终止条件可不加
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracting(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
