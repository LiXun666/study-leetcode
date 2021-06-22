package leetcode;

import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/4/16 11:40
 * @Description:
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return BST(nums, 0,n-1);
    }
    public TreeNode BST(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int pivot = start+(end - start)/2;
        TreeNode root =  new TreeNode(nums[pivot]);
        root.left = BST(nums,start,pivot-1);
        root.right = BST(nums,pivot+1,end);
        return root;
    }
}
