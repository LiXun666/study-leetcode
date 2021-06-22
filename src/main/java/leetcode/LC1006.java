package leetcode;

import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/4/1 13:12
 * @Description:
 * 笨阶乘
 */
public class LC1006 {
    //找规律
    public int clumsy(int N) {
        if(N < 2){
            return 1;
        }
        if( N == 2){
            return 2;
        }
        if( N == 3){
            return 6;
        }
        if(N == 4){
            return 7;
        }
        if(N % 4 == 0){
            return N + 1;
        }else if ( N % 4 <= 2){
            return N + 2;
        }else{
            return N-1;
        }
    }

    //用栈进行模拟
    public int clumsy2(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N--);

        int index = 0;
        while(N>0){
            if (index % 4 == 0){
                stack.push(stack.pop()*N);
            }else if(index % 4 == 1){
                stack.push(stack.pop()/N);
            }else if(index % 4 == 2){
                stack.push(N);
            }else{
                stack.push(-N);
            }
            index++;
            N--;
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
