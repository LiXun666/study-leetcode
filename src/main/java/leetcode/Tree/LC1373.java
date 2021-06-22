package leetcode.Tree;

import leetcode.TreeNode;

/**
 * @Author:lx
 * @Date: 2021/5/13 15:37
 * @Description: 二叉搜索子树的最大键值和
 */
public class LC1373 {
    //如果最大键值为负数，则返回0
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    private int[] postOrder(TreeNode root) {
        //root==null时算bst
        if (root == null) return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        //当前节点的状态
        int[] res = new int[4];

        //如果root为bst
        if (left[0] == 1 && right[0] == 1 && left[2] < root.val && right[1] > root.val) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = left[3] + right[3] + root.val;

            maxSum = Math.max(res[3], maxSum);
        } else {
            res[0] = 0;
        }
        return res;
    }

    //通过数组，来表示每个root的状态
    //res[0],该root为根的二叉树节点是否为bst，1是，0不是
    //res[1],root为根的最小值
    //res[2],root为根的最大致
    //res[3],键值和

}
