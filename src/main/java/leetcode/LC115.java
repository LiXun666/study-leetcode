package leetcode;

import javax.lang.model.type.ErrorType;

/**
 * @Author:lx
 * @Date: 2021/3/17 15:13
 * @Description:
 * 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 */
public class LC115 {
    /**
     * 此方法超时
    static int sum = 0;
    public static int numDistinct(String s, String t) {
        if (s.length() < t.length()){
            return 0;
        }
        char[] chars = s.toCharArray();
        process(chars,0,"",t);
        return sum;
    }

    //找到相同长度的子串
    public static void process(char[] chars, int i, String res, String t){
        if (i == chars.length){
            System.out.println(res);
            return;
        }
        process(chars,i+1,res,t);
        process(chars,i+1,res+chars[i],t);
    }

    public static void main(String[] args) {
        numDistinct("abc","bbb");
    }
     */

    //二维数组动态规划
    public static int numDistinct(String s, String t){
        int m = s.length();
        int n = t.length();
        if (m < n ){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        //j==n的话，t(n：)为空，他是任何s的子序列，故
        for (int i = 0; i <=m; i++) {
            dp[i][n] = 1;
        }
        //i==m的话，s(m:)为空，不可能有任何子串,故
        for (int i = m-1; i >= 0; i--) {
            char chart = s.charAt(i);
            for (int j = n-1; j >= 0; j--) {
                if (chart != t.charAt(j)){
                    dp[i][j] = dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j]+dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];

    }
}
