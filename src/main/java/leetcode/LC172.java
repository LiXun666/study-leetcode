package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/26 15:06
 * @Description:
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class LC172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }
    public static int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <=n; i += 5) {
            int of5 = 5;
            while (i % of5 ==0){
               res++;
               of5 *= 5;
            }
        }
        return res;
    }
}
