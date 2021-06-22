package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author:lx
 * @Date: 2021/4/16 13:17
 * @Description: 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 */
public class LC111 {
    //bfs，如果那个节点的两个子节点都为null,返回该层级
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = stack.pollFirst();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    stack.addLast(poll.left);
                }
                if (poll.right != null) {
                    stack.addLast(poll.right);
                }
            }
            depth++;
        }
        return depth;
    }

    //dfs
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
}
