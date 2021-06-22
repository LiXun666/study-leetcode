package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/26 10:36
 * @Description:
 * 删除排序链表中的重复元素
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
public class LC83 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = deleteDuplicates(head);
    }


    //时间O(N)
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null ){
            return head;
        }
        ListNode res = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                ListNode repeat = head;
                while(repeat.next!= null &&repeat.val == repeat.next.val){
                    repeat = repeat.next;
                }
                head.next = repeat.next;
                head = head.next;
            }else{
                head = head.next;
            }
        }
        return res;
    }

    //时间O(N)
    public static ListNode deleteDuplicates2(ListNode head){
        if(head == null ){
            return head;
        }
        ListNode cur = head;
        while(cur.next != null ){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

}
