package lxjj.demo.zjoffer;

import sun.print.SunMinMaxPage;

/**
 * @Description TODO
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n<=39
 * @Date 2020/9/22 19:58
 * @Created by lx
 */
public class ZJ7 {

    /**
     * 思路
     * 1，递归法：标准公式为：F(n)=F(n-1)+F(n-2);
     * 2，优化递归：使用数组存储元素
     * 3，存储优化：不需要数组所有都存，只需要存输出值的前两个 用 sum 存储第 n 项的值 one 存储第 n-1 项的值 two 存储第 n-2 项的值
     * 4，例如当计算完 f(5) 时 sum 存储的是 f(5) 的值，
     *  当需要计算 f(6) 时，f(6) = f(5) + f(4)，sum 存储的 f(5)，f(4) 存储在 one 中，由 f(5)-f(3) 得到
     *
     */
    public int Fibonacci(int n) {

        if(n<=1){
            return n;
        }

        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public int Fibonacci2(int n){
        int[] ints = new int[40];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i<=n; i++){
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[n];
    }

    public int Fibonacci3(int n){
        if(n==0){
            return 0;
        }else if (n==1){
            return 1;
        }
        int sum = 0;
        int f = 0;
        int s = 1;
        for (int i=2;i<=n;i++){
            sum = f+s;
            f = s;
            s = sum;
        }
        return sum;
    }

    public int Fibonacci4(int n){
        if(n==0){
            return 0;
        }else if (n==1){
            return 1;
        }
        int sum = 1;
        int f = 0 ;
        for (int i=2; i<=n; i++){
            sum = sum + f;
            f = sum - f;
        }
        return sum;
    }
}
