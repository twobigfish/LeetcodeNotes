package tree;

/**
 * @author: Dayuu
 * @description: 从中序与后序遍历序列构造二叉树
 */
public class leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderStart == postorderEnd) // 不满足左闭右开，说明没有元素，返回空树
            return null;
        // 后序遍历数组最后一个元素，就是当前的中间节点
        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        // 分割中序遍历数组，分为左、右两个
        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) { // 左闭右开
            if (inorder[middleIndex] == rootVal)
                break;
        }
        // 左中序遍历数组
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex; // 左闭右开
        // 右中序遍历数组
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd; // 左闭右开

        // 分割后序遍历
        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);
        int rightPostorderStart = leftPostorderEnd; // 左闭右开
        int rightPostorderEnd = postorderEnd - 1;

        //用数组构造二叉树的题目，每次分隔尽量不要定义新的数组，而是通过下标索引直接在原数组上操作，这样可以节约时间和空间上的开销。
        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd, postorder, leftPostorderStart, leftPostorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostorderStart, rightPostorderEnd);

        return root;
    }
}
