package leetcode;

import javax.swing.plaf.SliderUI;

/**
 * @Author:lx
 * @Date: 2021/4/15 13:58
 * @Description:
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class LC67 {
    //暴力法
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = n-1,j = m-1; i>=0 &&j>=0; i--,j--){
            int ca = a.charAt(i)-'0';
            int cb = b.charAt(j)-'0';
            if (ca + cb + flag == 0){
                sb.append(0);
                flag =0;
            }else if(ca+cb+flag == 1){
                sb.append(1);
                flag=0;
            }else{
                sb.append(ca+cb+flag - 2);
                flag = 1;
            }
        }
        if (n>=m) {
            for (int i = n-m-1; i >=0 ; i--) {
                int ca = a.charAt(i)-'0';
                if (ca+flag == 0){
                    sb.append(0);
                    flag = 0;
                }else if (ca+flag == 1){
                    sb.append(1);
                    flag =0;
                }else{
                    sb.append(0);
                    flag =1;
                }
            }
        }else{
            for (int i = m-n-1; i >=0 ; i--) {
                int ca = b.charAt(i)-'0';
                if (ca+flag == 0){
                    sb.append(0);
                    flag = 0;
                }else if (ca+flag == 1){
                    sb.append(1);
                    flag =0;
                }else{
                    sb.append(0);
                    flag =1;
                }
            }
        }
        if (flag == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
    //稍微优化
    public String addBinary2(String a, String b){
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            int sum = carry;
            sum += a.charAt(i--)-'0';
            sum += b.charAt(j--)-'0';
            carry = sum/2;
            sb.append(sum%2);
        }
        while(i>=0){
            int sum = carry + a.charAt(i--) - '0';
            carry = sum/2;
            sb.append(sum%2);
        }
        while(j>=0){
            int sum = carry + b.charAt(j--) - '0';
            carry = sum/2;
            sb.append(sum%2);
        }
        if (carry == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
