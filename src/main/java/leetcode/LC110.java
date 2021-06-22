package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/16 12:58
 * @Description:
 *  平衡二叉树
 *  给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class LC110 {
    //因为每个节点也需要满足，所以两次递归
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = dep(root.left);
        int right = dep(root.right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dep(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(dep(root.left),dep(root.right))+1;
    }
}
