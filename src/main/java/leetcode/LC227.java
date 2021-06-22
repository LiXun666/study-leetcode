package leetcode;

import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/11 17:30
 * @Description:
 * 基本计算器 II
 *给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 */
public class LC227 {
    public int calculate(String s) {

        return 0;
    }

    //返回该运算符的优先级
    public int operPriority (char oper){
        if (oper == '+' || oper == '-'){
            return 0;
        }else{
            return 1;
        }
    }

}
