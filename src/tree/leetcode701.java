package tree;

/**
 * @author: Dayuu
 * @description: 二叉搜索树中的插入操作
 */
public class leetcode701 {
    // 法1 递归
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果当前节点为null，则创建新节点并返回
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // 法2 迭代
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) return node; // 若root为空，则直接插入该节点。

        TreeNode parentnode = null;
        TreeNode cur = root;
        while (cur != null) {
            parentnode = cur;
            if (val < cur.val) {
                cur = cur.left;
            } else if (val > cur.val) {
                cur = cur.right;
            }
        }

        if (val < parentnode.val) {
            parentnode.left = node;
        } else {
            parentnode.right = node;
        }

        return root;
    }
}
