package zjoffer;

import java.util.List;

/**
 * @Description TODO
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @Date 2020/10/4 15:52
 * @Created by lx
 */
public class ZJ14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：
     * 快慢指针，快指针先走k步，然后两个指针一起走
     * 直到快指针走到链表的null位置，此事慢指针刚好是倒数第k个节点
     *
     */
    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null || k==0){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1;i<=k;i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }

        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
