package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-27 16:39
 * @Description
 */
public class HJ35 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int a = in.nextInt();
            int cur = 1,col=a;
            for(int i = 0; i<a;i++){
                cur += i;
                int first = cur;
                for(int j = 0; j<col;j++){
                    System.out.print(first);
                    first += i+j+2;
                }
                col--;
                System.out.println();
            }
        }
    }
}
