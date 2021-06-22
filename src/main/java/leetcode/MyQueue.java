package leetcode;

import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/5 9:57
 * @Description:
 * 用栈实现队列
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作
 */
public class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //应该从outStack中删除
        if (outStack.isEmpty()){
            in2Out();
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()){
            in2Out();
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    public void in2Out(){
        while ( inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
