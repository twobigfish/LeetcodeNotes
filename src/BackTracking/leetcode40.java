package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 组合总和II
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
public class leetcode40 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        used = new boolean[candidates.length];
        Arrays.fill(used, false);

        backtracking(candidates, target, 0);
        return result;
    }
    /**
     * leetcode40,47,90
     * 40：组合（有重复元素->需要Arrays.sort）   无序  需要startIndex
     * 47：排列（有重复元素->需要Arrays.sort）   有序  不需要startIndex，每次回溯都是从i=0开始，也因此排列问题必然需要一个used来判断同一树枝中是否使用过当前元素
     * 90：子集（有重复元素->需要Arrays.sort）   无序  需要startIndex
     */
    void backtracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target){
                break;
            }
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 我们要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }

            sum += candidates[i];
            used[i] = true;
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    /**
     *   private void backTracking(int[] candidates, int target) {
     *     if (sum == target) {
     *       ans.add(new ArrayList(path));
     *     }
     *     for (int i = 0; i < candidates.length; i++) {
     *       if (sum + candidates[i] > target) {
     *         break;
     *       }
     *       // TODO i如果每次从0开始，则会出现[1,1,6]和[6,1,1]，但是组合是无顺序，这两个结果重复了。
     *       if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
     *         continue;
     *       }
     *       //TODO 所以不能像全排列leetcode47那样：每次都从0开始，前面组合用过的元素还可以用，排列是有顺序的，顺序不同，结果是不同的
     *       if(used[i]==true){
     *           continue;
     *       }
     *       used[i] = true;
     *       sum += candidates[i];
     *       path.add(candidates[i]);
     *       // 每个节点仅能选择一次，所以从下一位开始
     *       backTracking(candidates, target);
     *       used[i] = false;
     *       sum -= candidates[i];
     *       path.removeLast();
     *     }
     *   }
     */


}
