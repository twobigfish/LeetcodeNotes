package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 二叉搜索树中的众数
 */
public class leetcode501 {
    // 法1 暴力法
    // 遍历二叉搜索树，用map统计频率，排序频率，取数


    // 法2
    public int[] findMode(TreeNode root) {
        TreeNode pre = null; // 记录前一个节点
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        int count = 0; // 频率
        int maxcount = 0;

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                // 计数
                if (pre == null || pre.val != root.val) { // 第一次遍历到该数字
                    count = 1;
                } else {
                    count++;
                }
                // 更新结果
                if (count > maxcount) {
                    res.clear();
                    maxcount = count;
                    res.add(root.val);
                } else if (count == maxcount) {
                    res.add(root.val);
                }
                pre = root;
                root = root.right;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
