package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Dayuu
 * @description: 电话号码的字母组合
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
public class leetcode17 {
    List<String> res = new ArrayList<>();
    StringBuilder s1 = new StringBuilder();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        backtracking(digits, 0);
        return res;
    }

    void backtracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(new String(s1));
            return;
        }

        int num = digits.charAt(index) - '0'; // String转为int 23
        for (int i = 0; i < map[num].length(); i++) {
            s1.append(map[num].charAt(i));
            backtracking(digits, index + 1);
            s1.deleteCharAt(s1.length() - 1);
        }
    }
}
