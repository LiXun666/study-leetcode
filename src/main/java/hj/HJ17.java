package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-19 17:40
 * @Description
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            s = s.replaceAll(" ","");
            String[] str = s.split(";");
            int x= 0,y=0;

            for(int i = 0; i<str.length;i++){
                String st = str[i];
//                st.matches() 正则表达式"[AWSD]\\d{1}\\d?"
                if(isAvail(st)){
                    if(st.charAt(0)=='A'){
                        x -= Integer.valueOf(st.substring(1));
                    }else if(st.charAt(0)=='D'){
                        x += Integer.valueOf(st.substring(1));
                    }else if(st.charAt(0)=='S'){
                        y -= Integer.valueOf(st.substring(1));
                    }else if(st.charAt(0)=='W'){
                        y += Integer.valueOf(st.substring(1));
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }
    public static boolean isAvail(String st){
        int n = st.length();
        if(n < 2 || n > 3) return false;
        char ch = st.charAt(0);
        if(ch =='A'||ch=='D'||ch=='S'||ch=='W'){
            if(st.charAt(1)>='1'&&st.charAt(1)<='9'){
                if(n==2){
                    return true;
                }else{
                    return st.charAt(2) >= '0' && st.charAt(2) <= '9';
                }
            }
        }
        return false;
    }
}
