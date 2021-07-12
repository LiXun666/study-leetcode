package newcoder;


import javafx.scene.transform.Rotate;
import leetcode.TreeNode;

/**
 * @Author lxjj
 * @Date 2021-07-12 16:01
 * @Description
 */
public class NC11 {
    public static void main(String[] args) {
        int[] num = new int[]{};
        sortedArrayToBST(num);
    }
    public static TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        return toBST(num, 0, len - 1);
    }

    private static TreeNode toBST(int[] num, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left +1)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = toBST(num, left, mid - 1);
        root.right = toBST(num, mid + 1, right);
        return root;

    }
}
