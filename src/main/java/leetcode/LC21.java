package leetcode;

import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/3/18 23:36
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LC21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next =null;
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next =null;

        mergeTwoLists(l1,l2);
    }

    //迭代 O(m+n)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode index1 = l1;
        ListNode index2 = l2;

        ListNode head = new ListNode();
        ListNode cur = head;

        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                cur.next = index1;
                index1 = index1.next;
            }else {
                cur.next = index2;
                index2 = index2.next;
            }
            cur = cur.next;

        }
        if (index1 == null){
            cur.next = index2;
        }
        if (index2 == null){
            cur.next = index1;
        }
        return head.next;
    }


    //递归 O(m+n)
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }
}








