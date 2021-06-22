package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2020/10/20 22:00
 * @Description:
 */
public class LC143 {
    public void reorderList(ListNode head) {
        if (head == null){
            return ;
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();

        ListNode node = head;
        while (node!= null){
            list.add(node);
            node=node.next;
        }
        int i = 0;
        int j = list.size()-1;
        while (i<j){
            list.get(i).next = list.get(j);
            i++;
            if (i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }



     //Definition for singly-linked list.
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
