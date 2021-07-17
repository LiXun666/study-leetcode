package hj;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author lxjj
 * @Date 2021-07-15 17:29
 * @Description
 */
public class HJ50 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        pos = 0;
        System.out.print(compute(s));
    }
    static int pos;
    public static int compute(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char opt = '+';
        //把值全部转换成int存进去
        while(pos<s.length()){
            //遇到括号进行递归，把括号里的算完
            if(s.charAt(pos) == '{'||s.charAt(pos) == '('||s.charAt(pos) == '['){
                pos++;
                num = compute(s);
            }

            //如果是个数子
            while(pos<s.length() && Character.isDigit(s.charAt(pos))){
                num = num*10 + s.charAt(pos)-'0';
                pos++;
            }

            switch(opt){
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop()*num);
                    break;
                case '/':
                    stack.push(stack.pop()/num);
                    break;
            };
            //将num置为0
            num = 0;
            if(pos < s.length()){
                opt = s.charAt(pos);
                if(opt == '}'||opt== ')'||opt == ']'){
                    pos++;
                    break;
                }
            }
            pos++;
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

}