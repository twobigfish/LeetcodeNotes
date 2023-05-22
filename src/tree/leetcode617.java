package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Dayuu
 * @description: 合并二叉树
 */
public class leetcode617 {
    // 法1 递归
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    // 法2 迭代 使用队列模拟层序遍历，但不是真正意义上的层序遍历
    // 同时处理两棵树的思路：同leetcode101对称二叉树，都是把两个树的节点同时加入队列
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        // 判空 方式1
        /*if (root1 == null && root2 != null){
            return root2;
        }
        if (root1 != null && root2 == null){
            return root1;
        }
        if(root1 == null && root2 == null){
            return null;
        }*/

        // 判空 方式2
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        Deque<TreeNode> nodesque = new ArrayDeque<>();
        nodesque.offer(root1);
        nodesque.offer(root2);
        while (!nodesque.isEmpty()) {
            TreeNode node1 = nodesque.poll();
            TreeNode node2 = nodesque.poll();
            // 此时两个节点一定不为空，val相加
            node1.val = node1.val + node2.val;

            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null){
                nodesque.offer(node1.left);
                nodesque.offer(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null){
                nodesque.offer(node1.right);
                nodesque.offer(node2.right);
            }

            if (node1.right == null && node2.right != null){
                node1.right = node2.right;
            }
            if (node1.left == null && node2.left != null){
                node1.left = node2.left;
            }
            // node2.left/.right == null node1保持不变，可省略
            //if (node1.left != null && node2.left == null){
            //    node1.left = node1.left;
            //}
            //if (node1.right != null && node2.right == null){
            //    node1.right = node1.right;
            //}
        }
        return root1;
    }
}
