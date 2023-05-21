package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author: Dayuu
 * @description: 找树左下角的值
 * 思路：层序遍历 找最后一层的最左边的值
 */
public class leetcode513 {
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> nodelist = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode tempNode = queue.poll();
                list.add(tempNode.val);

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                len--;
            }
            nodelist.add(list);
        }
        return nodelist.get(nodelist.size() - 1).get(0);
    }
}
