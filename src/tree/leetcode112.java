package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Dayuu
 * @description: 路径总和
 */
public class leetcode112 {
    // 法1 递归 用累减
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum)) { // 回溯隐含在其中 每次递归的targetSum不一致
                return true;
            }
        }

        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)) {
                return true;
            }
        }
        return false;
    }

    // 法2 迭代 用累加
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stackNode = new ArrayDeque<>();
        Deque<Integer> stackVal = new ArrayDeque<>();
        stackNode.push(root);
        stackVal.push(root.val);
        while (!stackNode.isEmpty()) {
            TreeNode tmpnode = stackNode.pop();
            int sum = stackVal.pop();
            // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
            if (tmpnode.left == null && tmpnode.right == null && sum == targetSum) {
                return true;
            }
            // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
            if (tmpnode.right != null) {
                stackNode.push(tmpnode.right);
                stackVal.push(sum + tmpnode.right.val); // 存入的是累加后的值，没有把计算逻辑写在每一次遍历中，回溯被包含其中。
            }
            // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
            if (tmpnode.left != null) {
                stackNode.push(tmpnode.left);
                stackVal.push(sum + tmpnode.left.val);
            }
        }
        return false;
    }
}
