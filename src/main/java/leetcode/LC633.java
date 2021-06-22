package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/28 12:24
 * @Description:
 * 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class LC633 {
    public boolean judgeSquareSum(int c) {
        if(c == 1 || c ==0){
            return true;
        }
        int left = 0,right =(int)Math.sqrt(c);
        while (left <= right &&left*left + right*right != c){
            if (left*left + right*right == c){
                return true;
            }else if(left*left + right*right > c){
                right--;
            }else{
                left++;
            }
        }
        return left*left + right*right == c;
    }
}
