package lxjj.demo.zjoffer;

/**
 * @Description TODO
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Date 2020/10/10 12:13
 * @Created by lx
 */
public class ZJ16 {


    /**
     * 思路：
     * 递归
     * 如果list1小于list2，则list1作为新序列的开头，后面应该接的部分等同于list1.next和list2的重新排序。反之同理。
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }

    }

    /**
     * 思路：
     * 1.遍历两个链表，按大小顺序拼接。
     */
    public ListNode Merge2(ListNode list1,ListNode list2){
        ListNode newhead = new ListNode(0);
        ListNode movnode = newhead;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                movnode.next = list1;
                list1 = list1.next;
            }else{
                movnode.next = list2;
                list2 = list2.next;
            }
            movnode = movnode.next;
        }
        if (list1 != null){
            movnode.next = list1;
        }
        if (list2 != null){
            movnode.next = list2;
        }
        return newhead.next;
    }



    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}
