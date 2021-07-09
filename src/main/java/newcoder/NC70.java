package newcoder;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lxjj
 * @Date 2021-07-05 21:50
 * @Description 单链表的排序
 */
public class NC70 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(2);
        n1.next.next.next.next = new ListNode(9);
        n1.next.next.next.next.next = new ListNode(8);
        sortInList(n1);
    }


    //超时
    public static ListNode sortInList(ListNode head) {
        if(head == null|| head.next == null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort((o1, o2) -> o1.val - o2.val);
        ListNode res = list.get(0);
        ListNode cur = res;
        for (int i = 1; i < list.size(); i++) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        cur.next =null;
        return res;
    }

    //***归并排序
    public ListNode sortInList2(ListNode head){
        return sort(head,null);
    }

    private ListNode sort(ListNode start, ListNode end) {
        if(start == end)        return start;

        ListNode fast = start, slow = start;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = sort(slow.next, end);
        slow.next = null;
        ListNode l1 = sort(start, slow);


        return merge(l1, l2);
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
