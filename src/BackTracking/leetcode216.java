package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 组合总和III
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
public class leetcode216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        backtracking(k, n, 1);
        return res;

    }

    void backtracking(int k, int n, int startindex) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (list.size() > k || n < 0){
            return;
        }

        for (int i = startindex; i <= 9; i++) {
            list.add(i);
            backtracking(k, n - i, i + 1);
            list.remove(list.size()-1);
        }

    }
}
