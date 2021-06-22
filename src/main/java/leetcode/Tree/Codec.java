package leetcode.Tree;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/5/12 16:18
 * @Description:
 *  二叉树的序列化与反序列化
 */
public class Codec {
    // Encodes a tree to a single string.
    String NULL = "#";
    String SEP = ",";
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preOrder(root,sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deser(nodes);

    }

    private TreeNode deser(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deser(nodes);
        root.right = deser(nodes);
        return root;
    }
}
