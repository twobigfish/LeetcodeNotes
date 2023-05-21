package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 路径总和 II
 */
public class leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return result;
        }
        hasPathSum(root, targetSum, result, list);
        return result;
    }

    void hasPathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> list) {

        targetSum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0){
            result.add(new ArrayList<>(list)); // 一定要new一个，否则一直add的是同一个list，最后result中的结果全是相同的list
        }

        if (root.left != null){
            hasPathSum(root.left, targetSum, result, list);
            list.remove(list.size() - 1);
        }

        if (root.right != null){
            hasPathSum(root.right, targetSum, result, list);
            list.remove(list.size() - 1);
        }
    }
}
