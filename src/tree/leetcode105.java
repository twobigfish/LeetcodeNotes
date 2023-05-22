package tree;

/**
 * @author: Dayuu
 * @description: 从前序与中序遍历序列构造二叉树
 */
public class leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        // 结束条件
        if (prestart == preend) {
            return null;
        }

        int rootval = preorder[prestart];
        TreeNode root = new TreeNode(rootval);

        int inmid;
        for (inmid = instart; inmid < inend; inmid++) {
            if (inorder[inmid] == rootval) {
                break;
            }
        }
        // 分割中序遍历数组
        int leftmidstart = instart;
        int leftmidend = inmid;
        int rightmidstart = inmid + 1;
        int rightmidend = inend;

        // 分割前序遍历数组
        int leftprestart = prestart + 1;
        int leftpreend = leftprestart + (leftmidend - leftmidstart);
        int rightprestart = leftpreend;
        int rightpreend = preend;

        //用数组构造二叉树的题目，每次分隔尽量不要定义新的数组，而是通过下标索引直接在原数组上操作，这样可以节约时间和空间上的开销。
        root.left = build(preorder, leftprestart, leftpreend, inorder, leftmidstart, leftmidend);
        root.right = build(preorder, rightprestart, rightpreend, inorder, rightmidstart, rightmidend);
        return root;
    }

}
