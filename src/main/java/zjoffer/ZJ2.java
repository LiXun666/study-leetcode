package zjoffer;

import java.util.ArrayList;
import java.util.List;

public class ZJ2 {
    /*
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    public static void main(String[] args) {



        StringBuffer sb = new StringBuffer("h h h ");
        String s = replaceSpace(sb);
        System.out.println(s);
    }
    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
