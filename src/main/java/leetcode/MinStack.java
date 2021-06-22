package leetcode;

import org.omg.DynamicAny.DynSequence;
import zuo.demo_UnionFind;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/4/21 18:20
 * @Description:
 */
public class MinStack {
    Deque<int[]> stack1;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new LinkedList<>();
    }

    public void push(int val) {
        if (stack1.isEmpty()){
            stack1.push(new int[]{val,val});
        }else{
            stack1.push(new int[]{val,Math.min(val,stack1.peek()[1])});
        }
    }

    public void pop() {

        stack1.pop();
    }

    public int top() {
        return stack1.peek()[0];
    }

    public int getMin() {
        return stack1.peek()[1];
    }
}
