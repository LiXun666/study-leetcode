package newcoder;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lxjj
 * @Date 2021-07-12 20:42
 * @Description
 * 二叉树的最大深度
 */
public class NC13 {
    //bfs
    public int maxDepth (TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }
    //递归
    public int maxDepth2 (TreeNode root){
        return root==null ? 0 : Math.max(maxDepth2(root.left),maxDepth2(root.right))+1;
    }
}
