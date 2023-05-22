package tree;

import java.util.ArrayDeque;

/**
 * @author: Dayuu
 * @description: 二叉搜索树的最小绝对差
 */
public class leetcode530 {
    // 法1 最直观的想法，就是把二叉搜索树转换成有序数组，然后遍历一遍数组，就统计出来最小差值了。

    // 法2 在递归的过程中统计最小绝对差
    // 技巧：在递归中记录前一个节点**
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        return result;
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        // 左
        inorder(root.left);
        // 中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root; // 记录前一个节点
        // 右
        inorder(root.right);
    }
}

class Solution {
    // 法3 迭代
    // 技巧：在迭代中记录前一个节点**
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        int res = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null){
                    res = Math.min(res, root.val - pre.val);
                }
                pre = root;
                root = root.right;
            }
        }
        return res;
    }
}
