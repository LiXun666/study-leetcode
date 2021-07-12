package newcoder;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lxjj
 * @Date 2021-07-12 11:19
 * @Description
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class NC72 {
    //递归
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot == null) return pRoot;
        TreeNode temp = pRoot.right;
        pRoot.right = Mirror(pRoot.left);
        pRoot.left = Mirror(temp);
        return pRoot;
    }
    //bfs
    public TreeNode Mirror2 (TreeNode pRoot){
        if (pRoot == null) return pRoot;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;

            if (node.left !=null ) queue.offer(node.left);
            if (node.right !=null) queue.offer(node.right);
        }
        return pRoot;
    }
}
