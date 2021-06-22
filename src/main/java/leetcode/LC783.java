package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/4/13 13:17
 * @Description:
 * 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class LC783 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        minDiffInBST(root);
    }
    static List<Integer> list;
    public  static int minDiffInBST(TreeNode root) {
        list = new ArrayList<Integer>();
        dfs(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size()-1; i++){
            int a1 = list.get(i);
            int a2 = list.get(i-1);
            min = Math.min(min,a1-a2);
        }
        return min;
    }
    public static void dfs(TreeNode root){
        if(root != null){
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }

}
