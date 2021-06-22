package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/15 14:43
 * @Description:
 * x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class LC69 {
    public int mySqrt(int x) {
        if (x == 0 || x== 1){
            return x;
        }
        int res = 0;
        int left = 0;
        int right = x;
        while (left < right){
            int mid = left + (right-left)/2;
            if ((long) mid *mid <= x){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return x;
    }
}
