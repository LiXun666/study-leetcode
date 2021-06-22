package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/1 22:14
 * @Description:
 */
public class LC25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseKGroup(head,3);

    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k==1|| head == null ||head.next ==null){
            return head;
        }
        //每k个节点翻转一次
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        //需要完成t次
        int t = length/k;

        ListNode res = new ListNode(-1,head);
        ListNode pre = res;

        while(t>0){
            int n = k;
            ListNode precur = head;
            cur = precur.next;
            while(n > 1){
                ListNode temp = cur.next;
                pre.next = cur;
                cur.next = precur;


                precur = cur;
                cur = temp;
                n--;

            }
            pre = head;
            head.next = cur;
            head = head.next;
            t--;
        }
        return res.next;

    }
}
