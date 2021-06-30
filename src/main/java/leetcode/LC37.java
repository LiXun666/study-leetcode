package leetcode;

import javax.swing.*;
import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-06-30 10:28
 * @Description
 * 序列化与反序列化 bfs
 */
public class LC37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        String data = serialize(root);
        System.out.println(data);
        TreeNode node = deserialize(data);

        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        final String NU = "#";
        final String SEP = ",";

        Deque<TreeNode> stack = new ArrayDeque();
        stack.offer(root);
        sb.append(root.val);
        sb.append(SEP);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < stack.size(); i++) {
                TreeNode temp = stack.pop();
                if (temp.left == null) {
                    sb.append(NU);
                    sb.append(SEP);
                } else {
                    sb.append(temp.left.val);
                    sb.append(SEP);
                    stack.offer(temp.left);
                }

                if (temp.right == null) {
                    sb.append(NU);
                    sb.append(SEP);
                } else {
                    sb.append(temp.right.val);
                    sb.append(SEP);
                    stack.offer(temp.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        if (data.equals("")) {
            return null;
        }
        TreeNode root = new TreeNode();

        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = Integer.parseInt(split[0]);
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!split[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);
            }
            i++;
            if (!split[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

}
