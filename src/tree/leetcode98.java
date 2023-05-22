package tree;

import java.util.*;

/**
 * @author: Dayuu
 * @description: 验证二叉搜索树
 */
public class leetcode98 {
    // 法1 迭代法
    public boolean isValidBST1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root); // 中序遍历先访问的是中间节点root，因此访问完成后先放入栈中，去寻找或处理它的左节点
                root = root.left;
            } else {
                root = stack.pop(); // 中
                list.add(root.val);
                root = root.right;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 法2 递归法
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }
}
