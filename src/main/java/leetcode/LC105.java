package leetcode;

import jdk.nashorn.internal.ir.IdentNode;

/**
 * @Author:lx
 * @Date: 2021/5/11 16:19
 * @Description:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历的第一个数字为根节点，找到中序遍历的该数字，前面的为左子树，右边的为右子数
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright) {
        if (preleft > preright) return null;
        int rootval = preorder[preleft];
        int index = 0;
        for (int i = inleft; i <= inright; i++) {
            if (inorder[i] == rootval){
                index = i;
                break;
            }
        }
        int leftSize = index - inleft;

        TreeNode root = new TreeNode(rootval);
        root.left = build(preorder,preleft+1,leftSize+preleft,
                inorder, inleft,index-1);
        root.right = build(preorder,leftSize+preleft+1,preright,
                inorder, index+1,inright);
        return root;
    }
}
