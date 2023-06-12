package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 组合总和
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
public class leetcode39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //在求和问题中，排序之后加剪枝是常见的套路
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    /**
     * 如果是一个集合来求组合的话，就需要startIndex，例如：77.组合 (opens new window)，216.组合总和III (opens new window)。
     * 如果是多个集合取组合，各个集合之间相互不影响，那么就不用startIndex，例如：17.电话号码的字母组合
     */
    void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (target < sum) {
            return;
        }

        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) { //在求和问题中，排序之后加剪枝是常见的套路
                break;
            }
            path.add(candidates[i]);
            backtracking(candidates, target, i, sum);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
