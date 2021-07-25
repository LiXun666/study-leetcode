package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-23 23:24
 * @Description
 */
public class HJ52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();

            int m = a.length();
            int n = b.length();
            int res = Math.abs(m - n);
            //找最长公共子序列的长度
            int minCount = Math.max(m,n);
            int min = Math.min(m,n);
            for(int i = 0; i<a.length(); i++){
                for(int j = i+1;j<=a.length(); j++){
                    String temp = a.substring(i,j);
                    if(b.contains(temp)){
                        int jj = Math.abs(i - b.indexOf(temp));
                        minCount = Math.min(minCount,jj+min-temp.length());
                    }
                }
            }
            System.out.println(minCount+res);
        }
    }
}
