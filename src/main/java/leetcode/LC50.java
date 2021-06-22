package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/1 12:01
 * @Description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 */
public class LC50 {
    //快速幂+递归
    public double myPow(double x, int n) {
        long N = n;
        return N>=0? quickPow(x,N) : 1.0/quickPow(x,-N);
    }
    public double quickPow(double x, long n){
        if(n==0){
            return 1.0;
        }
        double y = quickPow(x, n/2);
        return n % 2 == 0? y*y : y*y*x;
    }
    //迭代
    public double quickPow2(double x, long n){
        double res = 1.0;
        double x_con = x;
        while(n>0){
            if(n%2 == 1){
                res *= x_con;
            }
            x_con *= x_con;
            n /= 2;
        }
        return res;
    }


}
