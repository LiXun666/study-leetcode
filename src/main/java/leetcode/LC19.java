package leetcode;

import leetcode.ListNode;

/**
 * @Author:lx
 * @Date: 2021/3/26 13:29
 * @Description:
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class LC19 {

    //遍历了两遍
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode res = new ListNode(0, head);
        while (head != null){
            head = head.next;
            length++;
        }
        int target = length - n;
        head = res;
        for (int i = 1; i < target ;i++){
            head = head.next;
        }
        head.next = head.next.next;

        return res.next;
    }

    //遍历一遍,用两个指针,前面的走到最后 后面的走到要删除的前一个
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode preNode = new ListNode(0, head);
        ListNode res = preNode;
        ListNode endNode = preNode;
        while (n > 0){
            endNode = endNode.next;
            n--;
        }

        //然后两个指针一起向后移动
        while (endNode.next != null){
            endNode = endNode.next;
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;

        return res.next;
    }
}
