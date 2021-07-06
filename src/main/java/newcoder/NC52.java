package newcoder;

import java.time.chrono.IsoChronology;
import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-06-29 17:08
 * @Description
 */
public class NC52 {
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        // write code here
        //遇见左括号压入栈，右括号
        Deque<Character> stack = new LinkedList<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c == '(' || c == '{' || c == '[') {
                stack.offer(c);
                continue;
            }
            char prechar = stack.peekLast();
            if (prechar == '(' && c == ')'
                    || prechar == '{' && c == '}'
                    || prechar == '[' && c == ']'){
                stack.pollLast();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
