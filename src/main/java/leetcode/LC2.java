package leetcode;

import javax.xml.transform.Templates;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:lx
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Date: 2020/10/27 16:33
 * @Description:
 */
public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head= null, tem = null;
        int carry = 0;
        //终止条件为两个链表都为null
        while (l1 != null || l2 != null){
            int n1 = l1 != null? l1.val:0;
            int n2 = l2 != null? l2.val:0;

            int sum = n1 + n2+carry;
            if (head == null){
                head = tem = new ListNode(sum%10);
            }else{
                tem.next = new ListNode(sum % 10);
                tem = tem.next;
            }
            carry = sum /10;
            if (l1 != null){
                l1 =l1.next;
            }
            if (l2 != null){
                l2 =l2.next;
            }
        }
        if (carry>0){
            tem.next = new ListNode(carry);
        }
        return head;
    }




    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
