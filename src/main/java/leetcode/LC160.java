package leetcode;

import java.util.HashSet;

/**
 * @Author:lx
 * @Date: 2021/4/21 19:36
 * @Description:
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点
 */
public class LC160 {
    //放在set里比对
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return headB;
    }
    //计算长度，在走
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB== null){
            return null;
        }
        int countA = 1;
        int countB = 1;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null){
            curA = curA.next;
            countA++;
        }
        while (curB != null){
            curB = curB.next;
            countB++;
        }
        while (countA > countB){
            headA = headA.next;
            countA--;
        }
        while (countB > countA){
            headB = headB.next;
            countB--;
        }
        while(headA != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
