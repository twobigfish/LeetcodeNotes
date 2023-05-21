package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Dayuu
 * @description: 左叶子之和
 * 这道题目要求左叶子之和，其实是比较绕的，因为不能判断本节点是不是左叶子节点。
 * 此时就要通过节点的父节点来判断其左孩子是不是左叶子了。
 * 平时我们解二叉树的题目时，已经习惯了通过节点的左右孩子判断本节点的属性，而本题我们要通过节点的父节点判断本节点的属性。
 */
public class leetcode404 {
    //法1 递归 后序遍历（左右中） 因为中间节点有对应的处理逻辑，即累加求sum，
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null) { // 左
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) { // 右
            sum += sumOfLeftLeaves(root.right);
        }
        // 只有当前遍历的节点是父节点，才能判断其子节点是不是左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) { // 中
            sum += root.left.val;
        }
        return sum;
    }

    //法2 迭代 本题迭代法使用前中后序都是可以的
    // 前序遍历 中左右
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            root = stack.removeFirst();
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val; // 中
            }
            if (root.right != null) {
                stack.addFirst(root.right); // 右
            }
            if (root.left != null) {
                stack.addFirst(root.left); // 左
            }
        }
        return sum;
    }
}
