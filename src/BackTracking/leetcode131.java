package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 分割回文串
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
public class leetcode131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    void backtracking(String s, int startindex) {
        //if (startindex >= s.length()) {  //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startindex == s.length()) {  //如果起始位置大于s的大小，说明找到了一组分割方案
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startindex; i < s.length(); i++) {
            //如果不是回文子串，则continue
            if (!ispartition(s, startindex, i)) {
                continue;
            }
            //s.subSequence(i,j) [i,j) 左闭右开
            String str = s.subSequence(startindex, i + 1).toString();
            path.add(str);
            //i+1：起始位置后移，保证不重复
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    boolean ispartition(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
