package newcoder;

import leetcode.TreeNode;

/**
 * @Author lxjj
 * @Date 2021-07-14 14:27
 * @Description
 * 二叉树中是否存在节点和为指定值的路径
 */
public class NC9 {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root== null) return false;
        return dfs(root,0,sum);
    }

    private boolean dfs(TreeNode root, int s, int sum) {
        if (root == null) return false;
        s += root.val;
        if (root.left == null && root.right == null && s== sum) return true;
        return dfs(root.left,s,sum) || dfs(root.right,s,sum);
    }
}
