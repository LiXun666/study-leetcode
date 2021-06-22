package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/12 16:02
 * @Description: 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class LC9 {
    //全部翻转判断是否相等
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int a = x;
        int rev = 0;
        int temp = 0;
        while (x != 0) {
            temp = x % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && temp > 7)) {
                return false;
            }
            if (rev < -Integer.MAX_VALUE / 10 || (rev == -Integer.MAX_VALUE / 10 && temp < -8)) {
                return false;
            }
            rev = rev * 10 + temp;
            x /= 10;
        }
        return rev == a;
    }
    //翻转后一半然后比较
    public boolean isPalindrome1(int x){
        if (x < 0 || (x%10 == 0 && x !=0)) {
            return false;
        }
        int rev = 0;
        while (x > rev ){
            int temp = x %10;
            rev = rev * 10 + temp;
            x /= 10;
        }
        return x==rev || x==rev/10;
    }
}
