package leetcode;

/**
 * @Author:lx
 * @Date: 2020/11/24 10:57
 * @Description:
 */
public class LC222 {
    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }
        //计算左右子树的层数 比如有3层，left为2
        int left = countLevel(root.left);
        int right = countLevel(root.right);

        if (left == right){
            //左子树满了，右子数没满
            return (1 << left) + countNodes(root.right);
        }else {
            //左子树没满，右子数满了
            return countNodes(root.left) + (1 << right);
        }
    }

    public int countLevel(TreeNode root){
        int level = 0;
        while (root.left != null){
            root = root.left;
            level++;
        }
        return level;
    }

     //Definition for a binary tree node.
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }

}
