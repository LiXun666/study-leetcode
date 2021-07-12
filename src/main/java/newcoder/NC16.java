package newcoder;

import leetcode.TreeNode;
import sun.plugin2.os.windows.FLASHWINFO;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author lxjj
 * @Date 2021-07-12 10:47
 * @Description 判断二叉树是否对称
 */
public class NC16 {
    //递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    //判断两个树是不是镜像的
    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }

    //bfs
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stact = new LinkedList();
        stact.offer(root.left);
        stact.offer(root.right);
        while (!stact.isEmpty()) {
            TreeNode left = stact.poll();
            TreeNode right = stact.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            stact.offer(left.left);
            stact.offer(right.right);
            stact.offer(left.right);
            stact.offer(right.left);
        }
        return true;
    }
}
