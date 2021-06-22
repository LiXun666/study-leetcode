package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/15 15:37
 * @Description:
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class LC70 {
    //超时
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
    public int climbStairs2(int n){
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = a+b;
            a = b;
            b =sum;
        }
        return b;
    }
}
