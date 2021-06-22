package leetcode.linklist;

import leetcode.ListNode;

/**
 * @Author:lx
 * @Date: 2021/4/29 10:39
 * @Description:
 * 部分反转链表
 */
public class LC92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        ListNode start = reverseBetween(head, 3, 4);

        ListNode in = start;
        while (in != null){
            System.out.print(in.val+"-->");
            in = in.next;
        }


    }
    //迭代翻转
    public static ListNode reverseBetween(ListNode head, int left, int right){
        ListNode preHead = new ListNode(-1,head);

        ListNode preRes = preHead;
        ListNode curNode = head;
        for (int i = 1; i < left; i++) {
            curNode = curNode.next;
            preRes = preRes.next;
        }

        ListNode nextNode = curNode.next;
        for (int i = 0; i < right - left; i++){
            curNode.next = nextNode.next;
            nextNode.next = preRes.next;
            preRes.next = nextNode;

            nextNode = curNode.next;
        }
        return preHead.next;
    }

    //递归实现
    public static ListNode reverseBetween2(ListNode head, int left, int right){
        if (left ==1){
            return resver(head,right);
        }
        head.next = reverseBetween2(head.next,left-1,right-1);
        return head;
    }

    static ListNode nextRight = null;
    private static ListNode resver(ListNode head, int right) {
        if (right == 1){
            nextRight = head.next;
            return head;
        }
        ListNode last = resver(head.next,right-1);
        head.next.next = head;
        head.next = nextRight;
        return last;
    }
}
