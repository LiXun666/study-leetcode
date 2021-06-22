package leetcode;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/3/12 10:36
 * @Description:
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LC5 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {

        int length = s.length();
        if(length == 0 || length == 1){
            return s;
        }
        boolean[][] f = new boolean[length][length];

        for (int i = 0; i < length; i++){
            Arrays.fill(f[i],true);
        }
        String ans = s.substring(0,1);

        for (int i = length-1; i >= 0; i--){
            for (int j = i+1; j<length; j++){
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
                if (f[i][j] && j-i+1 > ans.length() ){
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }
}
