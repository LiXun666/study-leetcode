package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:lx
 * 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * @Date: 2020/10/27 11:14
 * @Description:
 */
public class LC144 {
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        add(root,list);

        return list;
    }

    public void add(TreeNode root,List<Integer> list){
        if (root==null){
            return ;
        }
        list.add(root.val);
        add(root.left,list);
        add(root.right,list);
    }

    //迭代
    public List<Integer> preorderTraversal1(TreeNode root){
        if (root ==null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode nowNode = stack.pop();
            list.add(nowNode.val);
            if (nowNode.right!=null){
                stack.push(nowNode.right);
            }
            if (nowNode.left!=null){
                stack.push(nowNode.left);
            }

        }
        return list;

    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
  }
}
