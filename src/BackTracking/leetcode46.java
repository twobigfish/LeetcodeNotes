package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 全排列
 */

/**
 * void backtracking(){
 * if(结束条件){
 * 存放符合条件的结果;
 * return;
 * }
 * for(选择：本层集合中元素（树中节点孩子的数量就是集合的大小）){
 * 处理该层递归
 * backtracking(路径，选择列表); //递归
 * 回溯处理
 * }
 * }
 */
public class leetcode46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }
    /**
     * leetcode46,77,78
     * 77:组合（无重复元素）   无序  需要startIndex
     * 46:排列（无重复元素）   有序  不需要startIndex，每次回溯都是从i=0开始，也因此排列问题必然需要一个used来判断同一树枝中是否使用过当前元素
     * 78:子集（无重复元素）   无序  需要startIndex
     */
    void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 因为题目给定的序列中没有重复元素，所以不需要考虑同一树层的重复问题

            // 因为一个元素只能只用一次，i每次都是从0开始，所以避免在一个树枝中同一个元素被重复取。
            if (used[i]==true){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums); // 在本题中，used都是全局的，每一层查询都是使用该used；leetcode491中的used只在同一层中有效；
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
