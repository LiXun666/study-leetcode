package leetcode.Tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/5/13 11:19
 * @Description:
 */
public class LC95 {

    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<>();
        //把每种子树记录下来，然后拼接
        return great(1,n);
    }

    private List<TreeNode> great(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high){
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            //找到所有左右树的组合
            List<TreeNode> leftTree = great(low,i-1);
            List<TreeNode> rightTree = great(i+1,high);

            //拼起来
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
