package newcoder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lxjj
 * @Date 2021-07-14 10:56
 * @Description 二叉搜索树的第k个结点
 */
public class NC81 {
    List<TreeNode> res = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        //二叉搜索数的中序遍历
        povitSearch(pRoot, 0);
        if (res.size() >= k && k >= 1) {
            return res.get(k - 1);
        }
        return null;
    }

    private void povitSearch(TreeNode pRoot, int i) {
        if (pRoot != null) {
            povitSearch(pRoot.left, i);
            res.add(pRoot);
            povitSearch(pRoot.right, i);
        }
    }
}
