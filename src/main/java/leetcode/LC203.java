package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/27 17:13
 * @Description:
 * 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prenode = preHead;
        while (head != null){
            while (head!=null && head.val == val){
                head = head.next;
            }
            prenode.next = head;
            if (head == null){
                break;
            }
            head = head.next;
            prenode = prenode.next;
        }
        return preHead.next;
    }
}
