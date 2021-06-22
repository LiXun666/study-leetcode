package leetcode;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/4/15 22:19
 * @Description:
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class LC101 {
    //广度优先遍历
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.right==null && root.left==null)){
            return true;
        }
        if (root.right==null || root.left==null){
            return false;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
        Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
        stack1.offer(root.left);
        stack2.offer(root.right);
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            TreeNode left = stack1.pop();
            TreeNode right = stack2.pop();
            if (left.val != right.val){
                return false;
            }
            if (left.left==null ^ right.right==null){
                return false;
            }
            if (left.right==null ^ right.left==null){
                return false;
            }
            if (left.left!=null){
                stack1.offer(left.left);
            }
            if (left.right!=null){
                stack1.offer(left.right);
            }
            if (right.right!=null){
                stack2.offer(right.right);
            }
            if (right.left!=null){
                stack2.offer(right.left);
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
    //深度优先遍历
    public boolean isSymmetric2(TreeNode root){
        if (root == null){
            return true;
        }
        return isEqu(root.left,root.right);
    }

    private boolean isEqu(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return (left.val == right.val &&isEqu(left.right, right.left) && isEqu(left.left,right.right));
    }
}
