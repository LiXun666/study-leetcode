package leetcode.Tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import leetcode.TreeNode;

/**
 * @Author:lx
 * @Date: 2021/5/13 12:14
 * @Description:
 * 二叉树的最近公共祖先
 */
public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null || root == p || root == q) return root;

         TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null && right == null){
            return null;
        }else if (left != null && right !=null){
            return root;
        }

        return left == null ? right : left;

    }
}
