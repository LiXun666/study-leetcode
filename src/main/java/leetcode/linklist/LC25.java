package leetcode.linklist;

import leetcode.ListNode;

/**
 * @Author:lx
 * @Date: 2021/4/29 14:09
 * @Description:
 * K 个一组翻转链表
 */
public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k){
        if (head == null){
            return head;
        }
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if(b == null){
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b,k);
        return newHead;

    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre,cur,next;
        pre = null;
        cur = a;
        while (cur != b){
            next = a.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
