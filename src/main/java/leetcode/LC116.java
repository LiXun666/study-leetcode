package leetcode;

import java.util.LinkedList;

/**
 * @Description TODO
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @Date 2020/10/15 10:11
 * @Created by lx
 */
public class LC116 {
    public Node connect(Node root) {

        if (root == null){
            return root;
        }
        //初始化一个链表
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){

            //得到当前链表的大小
            int size = queue.size();

            //遍历后一层
            for (int i = 0; i <size; i++){
                //把第一个元素取出来，queue中就没有该元素了
                Node node = queue.poll();

                //node.next等于queue链表中的第一个
                if (i<size-1){
                    node.next = queue.peek();
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }

            }
        }
        return root;
    }

//    public Node connect1(Node root){
//
//    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}


