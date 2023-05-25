package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 组合
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

public class leetcode77 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    void backtracking(int n, int k, int startIndex) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list)); // new一个加入
            return;
        }

        // for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
        for (int i = startIndex; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtracking(n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
