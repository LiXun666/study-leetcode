package hj;

import java.util.List;
import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-29 17:14
 * @Description
 */
public class HJ49 {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int headv = sc.nextInt();
            head = new ListNode(headv);
            for (int i = 0; i < n - 1; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                insert(a, b);
            }
            head = delete(sc.nextInt());
            //打印；
            while (head != null){
                System.out.print(head.val+" ");
            }
            System.out.println();
        }
    }

    private static ListNode delete(int d) {
        ListNode cur = head;
        ListNode preH = new ListNode(-1, cur);
        ListNode pre = preH;
        while (cur != null) {
            if (cur.val == d) {
                pre.next = cur.next;
            } else {
                cur.next = cur;
                pre.next = pre;
            }
        }

        return preH.next;
    }

    private static void insert(int a, int b) {
        ListNode newNode = new ListNode(a);
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == b) {
                ListNode t = temp.next;
                temp.next = newNode;
                newNode.next = t;
                break;
            } else {
                temp = temp.next;
            }
        }
    }
}
