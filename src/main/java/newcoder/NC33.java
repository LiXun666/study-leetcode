package newcoder;

import leetcode.ListNode;

/**
 * @Author lxjj
 * @Date 2021-07-05 21:15
 * @Description
 * 合并有序链表
 */
public class NC33 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        System.out.println(mergeTwoLists(l1, l2).val);

    }
    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = l1;
        if (l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        }else{
            l1 = l1.next;
        }
        ListNode tail = head;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail=tail.next;
        }
        tail.next = (l1==null)?l2:l1;
        return head;

    }
}
