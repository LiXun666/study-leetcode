package datastructure.stack;

import com.sun.javafx.image.impl.IntArgb;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author:lx
 * 编写一个数组栈的代码。并测试
 * @Date: 2020/11/4 20:47快捷键
 * @Description:
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while (loop){
            System.out.println("show,显示栈");
            System.out.println("exit,退出程序");
            System.out.println("push,入栈");
            System.out.println("pop,出栈");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop= false;
                    System.out.println("程序退出");
                    break;
                case "push":
                    System.out.println("请输入一个数字");
                    int i = scanner.nextInt();
                    arrayStack.push(i);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("此次出栈的数据是%d \n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("输入错误重新输入");
                    break;
            }
        }
    }
}


//编写一个栈
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造方法
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，已经没有数据了~");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("已经没有数据了");
            return;
        }
        for (int i = top; i >=0; i--) {
            System.out.printf("stack[%d]=%d \n",i,stack[i]);
        }
    }
}
