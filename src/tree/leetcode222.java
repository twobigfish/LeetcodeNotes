package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Dayuu
 * @description: 完全二叉树的节点个数完全二叉树的节点个数
 */
public class leetcode222 {
    // 法1 递归 前序遍历
    // 时间复杂度：O(n)
    // 空间复杂度：O(log n)
    /*public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int num = leftNum + rightNum + 1;
        return num;
    }*/


    // 法2 迭代 层序
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                root = queue.poll();
                num++;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
                len--;
            }
        }
        return num;
    }

    // 法3 针对完全二叉树的解法
    // 满二叉树一定是完全二叉树，并且满二叉树的结点数为：2^depth - 1
    // 时间复杂度：O(log n × log n)
    // 空间复杂度：O(log n)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 1, rightDepth = 1;
        while (left != null) { // 求左子树的深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (int) (Math.pow(2, leftDepth) - 1); // 2^depth - 1
        }
        // 不是满二叉树，则继续递归左右子树，判断子树是不是满二叉树
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
