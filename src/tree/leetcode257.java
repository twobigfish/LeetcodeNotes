package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Dayuu
 * @description: 二叉树的所有路径
 */
public class leetcode257 {
    // 法1 递归 前序遍历
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val); // 前序遍历 中
        // 遇到叶子节点
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) { // 遍历 第1个 至 倒数第2个
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1)); // 最后1个节点单独处理
            res.add(sb.toString()); // 记录一个路径
            //return;
        }
        // 递归和回溯是同时进行，所以要放在同一个花括号里
        // 回溯和递归是一一对应的，有一个递归，就要有一个回溯
        if (root.left != null) { // 左
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1); // 回溯
        }
        if (root.right != null) { // 右
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1); // 回溯
        }
    }

    // 法2 迭代 前序遍历
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root.val + ""); // 路径
        stack.push(root); // 节点
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            TreeNode node = (TreeNode) stack.pop();
            String path = (String) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            // 右子节点不为空
            if (node.right != null) {
                stack.push(path + "->" + node.right.val);
                stack.push(node.right);
            }
            // 左子节点不为空
            if (node.left != null) {
                stack.push(path + "->" + node.left.val);
                stack.push(node.left);
            }
        }
        return res;
    }
}
