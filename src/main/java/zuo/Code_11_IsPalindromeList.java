package zuo;

import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/2 17:16
 * @Description:
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回
 * 文结构。 例如： 1->2->1，返回true。 1->2->2->1，返回true。
 * 15->6->15，返回true。 1->2->3，返回false。
 */
public class Code_11_IsPalindromeList {
    public static void main(String[] args) {

    }
    //需要n的 额外空间
    //使用栈
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //快慢指针，快指针移动两步，慢指针移动一步，快指针到最后
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null ){
            return true;
        }
        Node cur = head;
        Node right = head.next;
        while (cur.next != null && cur.next.next != null){
            cur = cur.next.next;
            right = right.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
}
