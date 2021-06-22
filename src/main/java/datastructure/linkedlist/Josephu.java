package datastructure.linkedlist;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.security.PrivateKey;

/**
 * @Author:lx
 * Josephu环：
 * 编写了一个Josephu，并测试
 * @Date: 2020/11/4 15:56
 * @Description:
 */
public class Josephu {
    public static void main(String[] args) {

        CircleSingleLinked circleSingleLinked = new CircleSingleLinked();
        circleSingleLinked.addBoy(5);
        circleSingleLinked.showBoy();
        circleSingleLinked.countBoy(1,2,5);
    }

}
//创建一个环形单项链表
class CircleSingleLinked{
    //先创建一个first节点，没有编号，后面给
    private Boy first = null;
    //添加节点，使其构成一个环形链表
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("小孩数量太少");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i==1){
                first = boy;
                first.setNext(first);//使第一个小孩自己构成一个环
                curBoy = first;
            }
            curBoy.setNext(boy); //前一个的next指向新的
            boy.setNext(first);//新的next指向first
            curBoy = boy; //curBoy指向新的 构成一个环
        }
    }
    //遍历当前环形链表
    public void showBoy(){
        //判断一下链表是否是空的
        if (first == null){
            System.out.println("是一个空链表");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("当前小孩的编号是："+ curBoy.getNo());
            if (curBoy.getNext() ==first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //数小孩且出圈
    public void countBoy(int startNo,int countNum,int nums){
        if (first==null || startNo < 1 || startNo>nums){
            System.out.println("输入的参数有误，请重新输入");
            return;
        }
        Boy helper = first;
        //令helper指向最后一个
        while (helper.getNext() != first){
            helper = helper.getNext();
        }
        //现在first移动到开始的startNo
        for (int i = 0; i < startNo-1; i++) {
             first = first.getNext();
             helper = helper.getNext();
        }
        //现在应该让first指向的小孩出圈
        while (true){
            for (int i = 0; i < countNum-1; i++) {
                 first = first.getNext();
                 helper = helper.getNext();
            }
            System.out.printf("现在%d小孩出圈 \n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
            if (helper == first){
                System.out.printf("最后剩下的%d小孩",helper.getNo());
                break;
            }
        }
    }
}

//创建一个Boy类，表示每一个节点
class Boy{
    private int no; //表示学生编号
    private Boy next; //指向下一个节点，默认null
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
