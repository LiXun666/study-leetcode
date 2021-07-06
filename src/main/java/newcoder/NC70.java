package newcoder;

import leetcode.ListNode;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author lxjj
 * @Date 2021-07-05 21:50
 * @Description
 *  单链表的排序
 */
public class NC70 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(2);
        sortInList(n1);
    }
    public static ListNode sortInList (ListNode head) {
        // write code here
            List<ListNode> list = new ArrayList<>();
            while (head != null){
                list.add(head);
                head = head.next;
            }
            list.sort((o1, o2) -> o1.val- o2.val);
            ListNode res = new ListNode();
            ListNode cur = res;
            for(ListNode node : list){
                cur.next = node;
                cur = cur.next;
            }
            return res.next;
    }
}
