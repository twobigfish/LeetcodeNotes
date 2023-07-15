package DynamicProgramming_DP;

/**
 * @author: Dayuu
 * @description: 337.打家劫舍 III
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class leetcode337 {
    public int rob(TreeNode root) {
        int[] result = LRU(root);
        return Math.max(result[0], result[1]); // 返回最大的一个
    }

    public int[] LRU(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = LRU(root.left);
        int[] right = LRU(root.right);

        // 不偷当前节点 0
        int val1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点 1
        int val2 = root.val + left[0] + right[0];

        return new int[]{val1, val2};
    }
}
