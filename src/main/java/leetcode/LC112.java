package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author:lx
 * @Date: 2021/4/16 14:01
 * @Description:
 * 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class LC112 {

    //dfs
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return sum(root,targetSum,root.val);
    }
    private boolean sum(TreeNode root,int targetSum, int curSum){
        if (root.left == null && root.right == null){
            return curSum == targetSum;
        }
        boolean left =false;
        boolean right = false;
        if (root.left!=null){
            left = sum(root.left, targetSum, curSum + root.left.val);
        }
        if (root.right != null){
            right = sum(root.right, targetSum, curSum + root.right.val);
        }
        return left || right;
    }

    //dfs 2
    public boolean hasPathSum2(TreeNode root, int targetSum){
        if(root== null){
            return false;
        }
        if (root.left == null && root.right==null){
            return root.val == targetSum;
        }
        return hasPathSum2(root.left,targetSum-root.val) || hasPathSum2(root.right,targetSum-root.val);
    }

    //bfs
    public boolean hasPathSum3(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        Deque<TreeNode> deNode = new ArrayDeque<>();
        Deque<Integer> deVal = new ArrayDeque<>();
        deNode.offer(root);
        deVal.offer(root.val);
        while (!deNode.isEmpty()){
            TreeNode nowNode = deNode.poll();
            int nowVal = deVal.poll();
            if (nowNode.left == null && nowNode.right == null && targetSum == nowVal){
                return true;
            }
            if (nowNode.left!=null){
                deNode.offer(nowNode.left);
                deVal.offer(nowVal+nowNode.left.val);
            }
            if (nowNode.right != null){
                deNode.offer(nowNode.right);
                deVal.offer(nowVal+nowNode.right.val);
            }
        }
        return false;
    }
}
