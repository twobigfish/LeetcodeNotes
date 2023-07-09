package GreedyAlgorithm;

import javax.swing.tree.TreeNode;

/**
 * @author: Dayuu
 * @description: 监控二叉树
 */
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}*/

public class leetcode968 {
    int res = 0;
/*
    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态 .
        if (CameraCover(root) == 0) {
            res++;
        }
        return res;
    }

    *//**
     * 节点的状态值：
     * 0 表示无覆盖
     * 1 表示 有摄像头
     * 2 表示有覆盖
     * 后序遍历，根据左右节点的情况,来判读 自己的状态
     *//*
    public int CameraCover(TreeNode root) {
        if (root == null) {
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }

        int left = CameraCover(root.left); // 左
        int right = CameraCover(root.right); // 右
        // 中
        //  情况1 左右都有覆盖
        //  如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if (left == 2 && right == 2) {
            return 0;
        }
        // 情况2 左或右 无覆盖
        // 左右节点 是无覆盖状态,那 父节点此时应该放一个摄像头
        // (0,0) (0,1) (0,2) (1,0) (2,0)
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        // 情况3 左或右 有摄像头 情况3需要在情况2之后
        // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
        // 那么本节点就是处于被覆盖状态
        if (left == 1 || right == 1) {
            return 2;
        }

        return -1;
    }
*/
}
