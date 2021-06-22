package leetcode.Tree;

import leetcode.TreeNode;

/**
 * @Author:lx
 * @Date: 2021/5/12 11:35
 * @Description: 判断bst的合法性
 */
public class BST {

    //判断合法性
    public boolean isvaildBST(TreeNode root) {
        return isvaild(root, null, null);
    }
    private boolean isvaild(TreeNode root, TreeNode min, TreeNode max) {
        //每个节点需要和自己左右比较
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isvaild(root.left,min,root) && isvaild(root.right,root,max);
    }

    //判断一个数在不在bst中
    public boolean isInBST(TreeNode root, int target){
        if (root == null) return false;
        if (root.val == target){
            return true;
        }
        if (root.val > target){
            return isInBST(root.left,target);
        }else{
            return isInBST(root.right,target);
        }
    }

    //插入一个target
    public TreeNode insertBST(TreeNode root, int target){
        if (root == null){
            return new TreeNode(target);
        }
        if (root.val > target){
            root.left =  insertBST(root.left,target);
        }
        if (root.val < target){
            root.right = insertBST(root.right,target);
        }
        return root;
    }

    //删除节点
    public TreeNode deleteBST(TreeNode root, int target){
        //找个该节点
        if (root == null) return null;
        if (root.val == target){
            //进行删除操作，
            //1.只有一个节点，删除那个节点
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            //有两个节点，找到右子数的最小节点删除
            int minRight = getMinRight(root.right);
            root.val = minRight;
            root.right = deleteBST(root.right,minRight);
        }
        if (root.val > target){
            root.left =  deleteBST(root.left,target);
        }
        if (root.val < target){
            root.right = deleteBST(root.right,target);
        }
        return root;
    }

    private int getMinRight(TreeNode right) {
        while (right.left !=null){
            right = right.left;
        }
        return right.val;
    }
}
