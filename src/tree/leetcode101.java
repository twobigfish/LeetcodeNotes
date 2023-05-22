package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dayuu
 * @create 2023/5/14 20:36
 * 对称二叉树
 */
public class leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    // 递归法
    boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }

    // 迭代法
    public boolean isSymmetric2(TreeNode root) {
        /**
         * Queue、Deque、LinkedList、ArrayDeque关系及方法
         * 参考：https://blog.csdn.net/m0_37520426/article/details/115413748
         */

        /**
         * Deque<TreeNode> deque = new ArrayDeque<>();
         * ArrayDeque类插入null时会报NullPointerException的错误，如果要对Deque进行加入null元素的操作，选择LinkedList类
         * 参考：https://blog.csdn.net/qq_43708373/article/details/121344145
         */
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftnode = deque.removeFirst();
            TreeNode rightnode = deque.removeLast();
//            if (leftnode == null && rightnode == null) {
//                continue;
//            }
//            if (leftnode == null || rightnode == null || leftnode.val != rightnode.val) {
//                return false;
//            }
            if (leftnode == null && rightnode != null) {
                return false;
            }
            if (leftnode != null && rightnode == null) {
                return false;
            }
            if (leftnode == null && rightnode == null) {
                continue;
            }
            if (leftnode.val != rightnode.val) {
                return false;
            }

            // outside
            deque.addFirst(leftnode.left);
            deque.addLast(rightnode.right);
            deque.addFirst(leftnode.right);
            deque.addLast(rightnode.left);
        }
        return true;
    }
}
