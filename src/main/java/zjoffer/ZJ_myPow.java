package zjoffer;

/**
 * @Author:lx
 * @Date: 2021/4/14 14:33
 * @Description:
 * 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class ZJ_myPow {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? pow(x,N) : 1.0 / pow(x,-N);

    }
    public double pow(double x, long n){
        double res = 1.0;
        double res_con = x;
        while(n > 0){
            if (n % 2 == 1){
                res *= res_con;
            }
            res_con *= res_con;
            n /= 2;
        }
        return res;
    }
    public double pow2(double x, long n){
        if (n==0){
            return 1.0;
        }
        double y = pow(x,n/2);
        return n % 2 == 0? y*y : y*y*x;
    }
}
