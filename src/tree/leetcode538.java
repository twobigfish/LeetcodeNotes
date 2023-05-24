package tree;

/**
 * @author: Dayuu
 * @description: 把二叉搜索树转换为累加树
 */
public class leetcode538 {
    int sum = 0; // 记录前一个节点的数值
    public TreeNode convertBST(TreeNode root) {
        conver(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    void conver(TreeNode root) {
        if (root == null) {
            return;
        }
        conver(root.right);
        sum += root.val;
        root.val = sum;
        conver(root.left);
    }
}
