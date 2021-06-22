package leetcode.Tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/5/12 10:18
 * @Description:
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class LC230 {
    int res = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历，如果k等于0了 就返回该数
        inorder(root,k);
        return res;
    }

    private void inorder(TreeNode root,int k) {
        if (root == null){
            return;
        }
        inorder(root.left,k);
        rank++;
        if (rank == k){
            res = root.val;
            return;
        }

        inorder(root.right,k);
    }
}
