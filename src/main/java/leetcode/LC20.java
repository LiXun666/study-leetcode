package leetcode;

import java.lang.annotation.ElementType;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/18 23:03
 * @Description:
 * 有效括号
 */
public class LC20 {
    public static void main(String[] args) {
        String s= "()";
        System.out.println(isValid(s));
    }

    public static  boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if (!stack.isEmpty()){
                if (c - stack.peek() ==2 || c - stack.peek() ==1 ){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
            index++;
        }
        return stack.isEmpty();
    }
}
