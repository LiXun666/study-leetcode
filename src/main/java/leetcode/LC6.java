package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/12 12:09
 * @Description:
 * Z 字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * 思路:
 * 1.遍历每行，第0行是 k*(2*n-2)
 * 2.中间每行的是k*(2*n-2)+i,中间的是(k+1)*(2*n-2)-i; 数字的大小不能超过
 * 3.第numRows-1行是  k*(2*n-2)+n-1
 */
public class LC6 {
    public String convert(String s, int numRows) {
        int c = 2*s.length() -2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< numRows;i++){
            //最大不超过 j+i
            for (int j = 0; j+i < s.length(); j += c){
                sb.append(s.charAt(j+i));
                if (i != 0 && i != s.length()-1 && j+c-i < s.length()){
                    sb.append(s.charAt(j+c-i));
                }
            }
        }
        return sb.toString();
    }
}
