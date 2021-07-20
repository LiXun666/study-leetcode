package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-20 0:47
 * @Description
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String pwd = in.nextLine();
            boolean flag = false;
            if(pwd.length()<=8){
                System.out.println("NG");
                continue;
            }
            if(noDouble(pwd)){
                System.out.println("NG");
                continue;
            }
            //0大写，1小写，2 数字 3其他
            int upper = 0,lower=0,num=0,other=0;
            for(int i = 0; i<pwd.length();i++){
                char c = pwd.charAt(i);
                if(c>='A'&&c<='Z'){
                    upper=1;
                }else if(c>='a'&&c<='z'){
                    lower=1;
                }else if(c>='0'&&c<='9'){
                    num=1;
                }else{
                    other=1;
                }
            }
            if(upper+lower+num+other < 3){
                System.out.println("NG");
            }else{
                System.out.println("OK");
            }
        }
    }
    public static boolean noDouble(String s){
        int n = s.length();
        for(int i = 0; i< n-3;i++){
            String temp = s.substring(i,i+3);
            for(int j = i+3; j<n-3; j++){
                if(temp.equals(s.substring(j,j+3))){
                    return true;
                }
            }
        }
        return false;
    }
}
