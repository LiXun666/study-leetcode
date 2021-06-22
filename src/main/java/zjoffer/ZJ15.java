package lxjj.demo.zjoffer;

/**
 * @Description TODO
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @Date 2020/10/8 17:12
 * @Created by lx
 */
public class ZJ15 {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode nex = null;

        while (head != null){
            nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }

        return pre;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
