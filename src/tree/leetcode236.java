package tree;

/**
 * @author: Dayuu
 * @description: 二叉树的最近公共祖先
 */
public class leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q) {
            return root;
        }

        // 单层逻辑
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 左
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 右

        // 中
        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right != null) { // 若找到两个节点，则当前节点是最近公共祖先
            return root;
        } else {
            return null;
        }
    }
}
