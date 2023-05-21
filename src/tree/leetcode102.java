package tree;

import java.util.*;

/**
 * @author dayuu
 * @create 2023/5/14 16:51
 * 二叉树的层序遍历
 */
public class leetcode102 {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root);
        return resList;
    }

    //BFS--迭代方式--借助队列
    public void checkFun(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
    }


}