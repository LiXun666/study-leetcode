package leetcode;

import java.util.ArrayList;

/**
 * @Author:lx
 * 回文链表:
 * 请判断一个链表是否为回文链表。
 * @Date: 2020/10/23 11:59
 * @Description:
 */
public class LC234 {
    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> listNodes = new ArrayList<Integer>();
        while (head != null){
            listNodes.add(head.val);
            head = head.next;
        }
        int size = listNodes.size();

        for (int i=0; i<size/2; i++){
            if(!listNodes.get(i).equals(listNodes.get(size-1-i))){
                return false;
            }
        }
        return true;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
}
