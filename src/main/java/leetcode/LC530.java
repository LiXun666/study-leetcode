package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @Date 2020/10/12 14:39
 * @Created by lx
 */
public class LC530 {

    /**
     * 考虑对升序数组a 求任意两个元素之差的绝对值的最小值，答案一定为相邻两个元素之差的最小值
     */
    //差值的最小值
    int min = Integer.MAX_VALUE;
    //前一个节点
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {

        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        //边界条件判断
        if (root == null)
            return;
        //左子树
        inorder(root.left);
        //对当前节点的操作
        if (prev != null)
            min = Math.min(min, root.val - prev.val);
        prev = root; //定义前一个节点
        //右子树
        inorder(root.right);
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
 }

}

