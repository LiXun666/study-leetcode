package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/4/25 17:42
 * @Description:
 */
public class LC897 {
    TreeNode dummyNode;
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        dummyNode = new TreeNode(-1);
        cur = dummyNode;
        pivot(root);
        return dummyNode.right;
    }

    private void pivot(TreeNode root) {
        if(root==null){
            return;
        }
        pivot(root.left);
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        pivot(root.right);
    }

}
