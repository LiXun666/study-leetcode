package leetcode;

import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/3/25 10:54
 * @Description:
 *
 * 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 */
public class LC82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }

        //prehead节点再重复节点之前
        //如果后面两个重复，需要删除重复节点
        //新找一个指针放在重复的第一个，找到所有重复的最后一个
        //让prehead.next指向最后一个的next
        ListNode preHead = new ListNode(0,head);
        ListNode res = preHead;

        while (preHead.next!=null && preHead.next.next != null){
            if (preHead.next.val == preHead.next.next.val){
                head = preHead.next;
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                preHead.next = head.next;
            }else {
                preHead = preHead.next;
            }
        }

        return res.next;

    }
}
