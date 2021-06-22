package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/5/26 12:48
 * @Description:
 * 反转每对括号间的子串
 */
public class LC1190 {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if(ch == ')'){
                sb.reverse();
                sb.insert(0,stack.pop());
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
