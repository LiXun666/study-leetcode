package leetcode;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-27 15:35
 * @Description
 */
public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            final int FACTOR = (int)Math.pow(2,8);
            if(a.contains(".")){
                String[] str = a.split("\\.");
                //第一个数字的最后一位，
                long res = 0;
                int index = 1;
                for(int i = 3; i>=0;i--){
                    int cur = Integer.valueOf(str[i]);
                    res += (long)cur*index;
                    index *= FACTOR;
                }
                System.out.println(res);
            }else{
                long sum =  Long.valueOf(a);
                int[] arr = new int[4];
                int index = FACTOR;
                for(int i = 3; i>=0; i--){
                    arr[i] = (int)(sum%FACTOR);
                    sum/= FACTOR;
                }
                for(int i=0; i<4;i++){
                    if(i==3){
                        System.out.println(arr[i]);
                    }else{
                        System.out.print(arr[i]+".");
                    }
                }
            }
        }
    }
}
