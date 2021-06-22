package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lx
 * 斐波那契数
 *斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * @Date: 2021/1/4 16:11
 * @Description:
 */
public class LC509 {
    public int fib(int n) {
        int a = 0;
        int b = 0;
        int c = 1;
        if (n<2){
            return n;
        }
        for (int i = 2; i <= n; i++){
            a = b;
            b = c;
            c  = a+b;
        }
        return c;
    }
    //递归
    public int fib1(int n){
        if (n<2){
            return n;
        }
        return fib1(n-1)+fib1(n-2);
    }
    //递归优化
    public int fib2(int n){
        return fib2(n,new HashMap());
    }
    public int fib2(int n, Map<Integer,Integer> map){
        if (n<2){
            return n;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int first = fib2(n-1,map);
        int second = fib2(n-2,map);
        int res = first + second;
        map.put(n,res);
        return res;
    }
}
