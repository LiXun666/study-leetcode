package leetcode;

import com.sun.corba.se.spi.ior.IORFactories;

/**
 * @Author:lx
 * @Date: 2021/4/27 11:47
 * @Description:
 * 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class LC938 {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        pivot(root,low,high);
        return res;
    }

    private void pivot(TreeNode root, int low, int high) {
        if (root == null){
            return;
        }
        pivot(root.left,low,high);
        if (root.val >= low && root.val<= high){
            res += root.val;
        }
        pivot(root.right,low,high);
    }
}
