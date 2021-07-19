package hj;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-19 19:46
 * @Description
 */
public class HJ19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<String> list = new ArrayList();
        //名字和行号
        Map<String,Integer> map = new HashMap();
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] strs = s.split(" ");
            String fileName = strs[0].substring(strs[0].lastIndexOf("\\")+1);
            String lineNum = strs[1];
            if(fileName.length() > 16) {
                fileName = fileName.substring(fileName.length()-16);
            }
            String sign = fileName+" "+lineNum;
            if(!map.containsKey(sign)){
                list.add(sign);
                map.put(sign,1);
                if (list.size()>8){
                    String remove = list.remove(0);
                }
            }else{
                map.put(sign,map.get(sign)+1);
            }
        }
        for (String s : list) {
            System.out.println(s+" "+map.get(s));
        }
    }
}
