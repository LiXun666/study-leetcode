package leetcode;

import org.w3c.dom.NodeList;

import java.awt.*;

/**
 * @Author:lx
 * @Date: 2021/3/18 13:35
 * @Description: 反转链表 II
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
 */
public class LC92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = null;
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = null;
        ListNode start = reverseBetween(head, 1, 2);

        ListNode in = start;
        while (in != null){
            System.out.print(in.val+"-->");
            in = in.next;
        }


    }

    //O(N),空间O(N),优化每次不需要新创建个变量，直接就用pre，cur，next三个变量变换
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next ==null || left >= right){
            return head;
        }
        ListNode start = new ListNode();
        start.next = head;
        ListNode preLeft = start;
        int index = 1;
        while (index < left){
            preLeft = preLeft.next;
            head = head.next;
            index++;
        }
        //preHead是left的前一个节点，head是left节点
        while (index < right){
            ListNode leftNode = preLeft.next;
            ListNode temp = new ListNode(head.next.val);

            head.next = head.next.next;
            preLeft.next = temp;
            temp.next = leftNode;

            index++;
        }
        return start.next;
    }


}
