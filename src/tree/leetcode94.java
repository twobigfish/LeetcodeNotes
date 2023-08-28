package tree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author dayuu
 * @create 2023/5/14 15:12
 * 中序遍历
 * 二叉树的遍历
 *    递归法：仅需要简单的调整递归的逻辑顺序
 *    迭代法：中序遍历特殊***
 *
 * 一定要掌握前中后序一种迭代的写法，并不因为某种场景的题目一定要用迭代，
 * 而是现场面试的时候，面试官看你顺畅的写出了递归，一般会进一步考察能不能写出相应的迭代。
 */

/*
public class TreeNode {
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
*/

public class leetcode94 {
    // 法1
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        indorder(root, result);
        return result;
    }

    // 左中右 递归
    public void indorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        indorder(root.left, result);
        result.add(root.val);  // 注意这一句的位置
        indorder(root.right, result);
    }

    // 法2 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        /**
         * 访问节点（遍历节点）和处理节点（将元素放进结果集）不一致的情况。
         * 中序遍历先访问的是中间节点root，因此访问完成后先放入栈中，去寻找或处理它的左节点
         */
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
