package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/4/16 11:21
 * @Description:
 * 二叉树的最大深度
 */
public class LC104 {
    //dfs
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //bfs
    public int maxDepth2 (TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pollFirst();
                if (pop.left != null){
                    stack.offer(pop.left);
                }
                if (pop.right != null){
                    stack.offer(pop.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
