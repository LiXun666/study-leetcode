package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-08-03 9:53
 * @Description
 */
public class HJ57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s1 = in.next();
            String s2 = in.next();

            int jinwei = 0;
            StringBuilder sb = new StringBuilder();
            int i = s1.length()-1,j = s2.length()-1;
            for(;i>=0&&j>=0;i--,j--){
                int a = s1.charAt(i)-'0';
                int b = s2.charAt(j)-'0';
                int c = a + b+jinwei;
                if (c < 10){
                    sb.append(c);
                    jinwei = 0;
                }else{
                    sb.append(c%10);
                    jinwei=c/10;
                }
            }
            if (j>=0){
                for (int k = j; k>=0;k--){
                    int sum1 = s2.charAt(k)-'0'+jinwei;
                    if (sum1 < 10){
                        sb.append(sum1);
                        jinwei = 0;
                    }else{
                        sb.append(sum1%10);
                        jinwei=sum1/10;
                    }
                }
            }
            if(i>=0){
                for (int k = i; k>=0;k--){
                    int sum2 = s1.charAt(k)-'0'+jinwei;
                    if (sum2 < 10){
                        sb.append(sum2);
                        jinwei = 0;
                    }else{

                        sb.append(sum2%10);
                        jinwei=sum2/10;
                    }
                }
            }
            if (jinwei>0){
                sb.append(jinwei);
            }
            System.out.println(sb.reverse());
        }
    }
}
