package datastructure.stack;

import java.util.Date;

/**
 * @Author:lx
 * @Date: 2020/11/5 18:14
 * @Description:
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*6-4";
        //初始化一个数栈，初始化一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //遍历表达式
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            //判断是不是个符号
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    //判断优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else{
                //numStack.push(ch-48);
                keepNum += ch;
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            index++;
            if (index >= expression.length()){
                break;
            }
        }

        //扫描完了，那么进行计算
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);

        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s的计算结果为%d",expression,res2);

    }


}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造方法
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，已经没有数据了~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //看一眼栈顶
    public int peek() {
        return stack[top];
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("已经没有数据了");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }

    //确定优先级
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }
        if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    //是否是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //进行计算
    public int cal(int num1, int num2, int oper){
        int res= 0;
        switch (oper){
            //必须每个case加break,不然会继续执行
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}
