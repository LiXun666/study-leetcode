package leetcode.Tree;

import leetcode.TreeNode;

import java.util.*;

/**
 * @Author:lx
 * @Date: 2021/5/12 9:52
 * @Description:
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 */
public class LC652 {
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //判断每个子树的子结构，采用后续遍历，记录每个节点的子树序列 ，如果有的话吧节点加进去
        rootToString(root);
        return res;
    }

    private String rootToString(TreeNode root) {
        if (root == null){
            return "#";
        }
        String left = rootToString(root.left);
        String right = rootToString(root.right);

        String s = left + "," + right + "," + root.val;
        int fre = map.getOrDefault(s, 0);
        if (fre==1){
            res.add(root);
        }
        map.put(s,fre+1);
        return s;
    }
}
