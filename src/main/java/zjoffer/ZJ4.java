package lxjj.demo.zjoffer;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description TODO
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Date 2020/9/16 10:00
 * @Created by lx
 */
public class ZJ4 {
    /**
     * 思路：
     * 根据前序序列第一个结点确定根结点
     * 根据根结点在中序序列中的位置分割出左右两个子序列
     * 对左子树和右子树分别递归使用同样的方法继续分解
     */
    public static void main(String[] args) {

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre, in));
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i=0; i<in.length; i++){
            if (in[i] == pre[0]){
                //左子树
                root.left=reConstructBinaryTree
                        (Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                //右子树
                root.right=reConstructBinaryTree
                        (Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;

    }


     //Definition for binary tree
     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }

}
