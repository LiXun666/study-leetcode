package newcoder;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author lxjj
 * @Date 2021-07-12 20:26
 * @Description 两个链表的第一个公共结点
 */
public class NC66 {
    //hashset
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    //不适用hashset,计算长度
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int count1 = 0, count2 = 0;
        while (cur1 != null){
            count1++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            count2++;
            cur2 = cur2.next;
        }
        if (count1 >= count2){
            int diff = count1 - count2;
            while (pHead1!=null && diff>0){
                pHead1 = pHead1.next;
                diff--;
            }
            while (pHead1 != null){
                if (pHead1 == pHead2) return pHead1;
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }else{
            int diff = count2-count1;
            while (pHead2!=null && diff>0){
                pHead2 = pHead2.next;
                diff--;
            }
            while (pHead2!=null){
                if (pHead1 == pHead2) return pHead1;
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}
