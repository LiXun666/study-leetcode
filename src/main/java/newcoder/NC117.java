package newcoder;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lxjj
 * @Date 2021-07-14 23:41
 * @Description 合并二叉树
 */
public class NC117 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        return dfs(t1, t2);
    }

    private TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null && t2 != null) {
            return t2;
        }else if(t1!=null && t2 ==null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = dfs(t1.left, t2.left);
        t1.right= dfs(t1.right, t2.right);
        return t1;
    }


//    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
//        // write code here
//        Queue<TreeNode> queue1 = new LinkedList();
//        Queue<TreeNode> queue2 = new LinkedList();
//        queue1.add(t1);
//        queue2.add(t2);
//        while (!queue1.isEmpty() && !queue2.isEmpty()){
//            TreeNode node1 = queue1.poll();
//            TreeNode node2 = queue2.poll();
//            if (node1 != null && node2 != null){
//
//            }
//        }
//    }
}
