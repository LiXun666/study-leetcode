package zjoffer;

import java.util.Stack;

/**
 * @Description    TODO
 *用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
            * @Date 2020/9/20 15:09
            * @Created by lx
 */
    public class ZJ5 {
        /**
         * 思路：
         *当插入时，直接插入 stack1
         * 当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
         */

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();



        public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        if (stack2.size() <= 0){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


}
