package zjoffer;

/**
 * @Description TODO
 *输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Date 2020/10/12 11:22
 * @Created by lx
 */
public class ZJ17 {

    /**
     * 思路:
     * 1，先遍历树A中的每个节点
     * 2，判断树A中以该点为跟节点的字数是否包含树B
     * recur()终止条件：
     *  当节点B为空：说明树B已匹配完成（越过叶子节点），因此返回 true   ；
     *  当节点A为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
     *  当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
     * recur()返回值：
     *  判断 A 和 B 的左、右子节点是否相等
     * HasSubtree()
     * ​若树B是树A的子结构，则必满足以下三种情况之一，因此用或 || 连接；
     *  以节点 A 为根节点的子树 包含树 B
     *  树 B 是 树 A 左子树的子结构，对应HasSubtree2(A.left, B)
     *  树 B 是 树 A 右子树的子结构，对应HasSubtree2(A.right,B)
     */

    //方法1
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 ==null || root2 == null)return false;

        if (root1.val == root2.val && (recur(root1.left, root2.left) && recur(root1.right, root2.right))) {
            return true;
        }
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    //方法2
    public boolean HasSubtree2(TreeNode A,TreeNode B){
        return (A != null && B != null) && (recur(A, B) || HasSubtree2(A.left, B) || HasSubtree2(A.right, B));

    }
    private boolean recur(TreeNode A ,TreeNode B){
        if (B==null){
            return true;
        }
        if (A == null || A.val != B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
