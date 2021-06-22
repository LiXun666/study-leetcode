package leetcode.linklist;

import leetcode.ListNode;

/**
 * @Author:lx
 * @Date: 2021/4/29 15:15
 * @Description:
 * 判断回文链表
 */
public class LC234 {
    ListNode left;
    public boolean isPalindrome(ListNode head){
        left = head;
        return reverse(head);
    }

    private boolean reverse(ListNode right) {
        if (right == null) return true;
        boolean res = reverse(right.next);

        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}
