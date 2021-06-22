package datastructure.hashtab;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

import java.security.Key;
import java.util.Scanner;

/**
 * @Author:lx
 * @Date: 2021/1/21 10:17
 * @Description: 用哈希表实现一个雇员管理系统
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建一个hashtab
        HashTable hashTable = new HashTable(7);
        //编写一个菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入add：添加雇员");
            System.out.println("输入list：显示所有信息");
            System.out.println("输入find：查找需要查找的id");
            System.out.println("输入delete：删除一个id");
            System.out.println("输入exit：退出程序");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("请输入要删除的id");
                    id = scanner.nextInt();
                    hashTable.delteEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

//创建一个hashtab用来管理多条链表
class HashTable {
    //创建一个链表数组
    public EmpLinkedList[] empLinkedListArray;
    public int size;

    //构造器
    public HashTable(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();

        }
    }

    //需要添加雇员
    public void add(Emp emp) {
        int empNo = hashFun(emp.id);
        empLinkedListArray[empNo].add(emp);
    }

    //遍历hash表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //查找雇员
    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].find(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到雇员id=%d\n", empLinkedListNo, emp.id);
        } else {
            System.out.println("没有找到该雇员");
        }
    }

    //删除一个id
    public void delteEmpById(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].delete(id);
    }

    //编写一个散列函数，找到该加入的员工需要放到哪一个链表中
    public int hashFun(int id) {
        return id % size;
    }
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next; //默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList,表示链表
//头指针指向第一个Emp,因此我们这个链表的head是直接指向第一个Emp
class EmpLinkedList {
    private Emp head;

    //添加emp方法
    //假定id是自增长的，即id的分配总是从小到大
    // 因此我们将该emp直接加入到最后
    public void add(Emp emp) {
        //如果添加的是第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个，需要找到最后一个加到后面
        //定义一个指针，寻找链表的最后
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        //退出循环后，需要吧emp加入链表
        curEmp.next = emp;
    }

    //遍历整个链表
    public void list(int no) {
        //如果当前链表为空，直接return,并提示
        //如果当前不是空，需要吧当前练链表的信息打印出来
        if (head == null) {
            System.out.printf("第%d链表为空", no + 1);
            System.out.println();
            return;
        }
        Emp curEmp = head;
        System.out.printf("第%d链表的信息为：", no);
        while (true) {
            System.out.printf("==》id:%d  name:%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp find(int id) {
        //如果该列的头结点为null,直接返回null
        if (head == null) {
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }

    //删除一个id
    public void delete(int id){
        if (head == null){
            System.out.println("没有该节点");
            return;
        }
        Emp curEmp = head;
        if (curEmp.id == id){
            System.out.println("该节点已经删除");
            head = head.next;
            return;
        }
        while (true){
            if (curEmp.next == null){
                System.out.println("没有找到该节点");
                return;
            }
            if (curEmp.next.id == id){
                //找到该节点了
                curEmp.next = curEmp.next.next;
                System.out.println("该节点已经删除");
                return;
            }
            curEmp = curEmp.next;
        }
    }
}

