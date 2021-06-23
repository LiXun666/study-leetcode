package zjoffer;

import java.util.ArrayList;

public class ZJ3 {
    /*
    输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     分析：
    listNode 是链表，只能从头遍历到尾，但是输出却要求从尾到头，这是典型的"先进后出"，我们可以想到栈！
    ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
    所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表
     */

    //非递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode tem =  listNode;
        while (tem != null){
            arrayList.add(0,tem.val);
            tem = tem.next;
        }
        return arrayList;

    }

    //递归
//    import java.util.*;
//    public class Solution {
//        ArrayList<Integer> list = new ArrayList();
//        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//            if(listNode!=null){
//                printListFromTailToHead(listNode.next);
//                list.add(listNode.val);
//            }
//            return list;
//        }
//    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

}
