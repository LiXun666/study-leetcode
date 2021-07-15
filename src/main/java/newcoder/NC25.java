package newcoder;

import leetcode.ListNode;

/**
 * @Author lxjj
 * @Date 2021-07-15 0:48
 * @Description
 *  删除有序链表中重复的元素-I
 */
public class NC25 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head==null) return null;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null){
            while (cur!=null && cur.val == pre.val){
                pre.next = cur.next;
                cur = cur.next;
            }
            if (cur == null) break;
            cur= cur.next;
            pre = pre.next;

        }
        return head;
    }
}
