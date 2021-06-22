package leetcode;

import com.sun.xml.internal.messaging.saaj.soap.SOAPVersionMismatchException;

/**
 * @Author:lx
 * 分隔链表
 *
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * @Date: 2021/1/3 21:48
 * @Description:
 */
public class LC86 {
    public ListNode partition(ListNode head, int x) {
        //slow 找第一个大于x的
        //fast找小于x的 ,preFast为fast前一个节点
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode preSlow = p;
        ListNode slow = head;
        ListNode preFast = head;
        ListNode fast = head.next;

        while (fast != null){
            if(slow.val < x){
                preSlow = slow;
                slow = preSlow.next;
                preFast = fast;
            }
            else if (fast.val < x ){
                preFast.next = fast.next;
                preSlow.next = fast;
                fast.next = slow;
                preSlow = fast;
            }else preFast = fast;

            fast = preFast.next;
        }

        return p.next;
    }

    public ListNode partition1(ListNode head, int x){
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }else{
                large.next =head;
                large = large.next;
            }
            head =head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }

}
