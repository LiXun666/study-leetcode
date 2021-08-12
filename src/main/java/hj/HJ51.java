package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-30 9:19
 * @Description
 */
public class HJ51 {
    public static void main(String args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            ListNode head = new ListNode(sc.nextInt());
            ListNode cur =head;
            for (int i = 0; i < n - 1; i++) {
                cur.next = new ListNode(sc.nextInt());
                cur = cur.next;
            }
            int k = sc.nextInt();
            //倒数第k，即为正数第n-k+1个节点；
            int index = 1;
            ListNode now =  head;
            while (index < n-k+1){
                now = now.next;
                index++;
            }
            System.out.println(now.val);
        }
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
