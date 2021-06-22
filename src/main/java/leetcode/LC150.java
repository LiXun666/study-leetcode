package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/21 20:42
 * @Description: 逆波兰表达式求值
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class LC150 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN2(tokens));
    }

    //使用栈，时间O(n),遍历了一遍  空间O(n),栈的大小不超过 tokens的长度
    public static int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new LinkedList<Integer>();
        int index = 0;
        while (index < tokens.length) {
            String token = tokens[index];
            if (isNum(token)) {
                numStack.push(Integer.parseInt(token));
            } else {
                //是一个运算符号，入符号栈
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        break;
                }
                numStack.push(res);
            }
            index++;
        }

        return numStack.pop();
    }

    public static boolean isNum(String ch) {
        return !(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"));
    }

    //使用数组模拟栈
    //数组栈中只放操作数，数量比操作符多一个，故长度最长为 n+1/2
    //时间复杂度O(n),数组栈的时间比较短，空间复杂度(n+1/2)
    public static int evalRPN2(String[] tokens){
        int n = tokens.length;
        int[] numStack = new int[(n + 1) / 2];
        int index = -1;
        for (int i = 0; i<n; i++){
            String ch = tokens[i];
            switch (ch){
                case "+":
                    index--;
                    numStack[index] += numStack[index+1];
                    break;
                case "-":
                    index--;
                    numStack[index] -= numStack[index+1];
                    break;
                case "*":
                    index--;
                    numStack[index] *= numStack[index+1];
                    break;
                case "/":
                    index--;
                    numStack[index] /= numStack[index+1];
                    break;
                default:
                    index++;
                    numStack[index] = Integer.valueOf(tokens[i]);
                    break;
            }
        }
        return numStack[index];
    }
}
