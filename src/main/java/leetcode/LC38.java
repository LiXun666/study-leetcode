package leetcode;

import javax.xml.transform.Result;
import java.util.PriorityQueue;

/**
 * @Author:lx
 * @Date: 2021/4/6 11:45
 * @Description:
 * 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 */
public class LC38 {

    //循环
    public String countAndSay(int n) {
        StringBuffer res = new StringBuffer();
        res.append(1);
        for (int i = 1; i < n; i++) {
            StringBuffer s = new StringBuffer();
            int start = 0;
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) != res.charAt(start)){
                    s.append(j-start).append(res.charAt(start));
                    start = j;
                }
            }
            s.append(res.length()-start).append(res.charAt(start));
            res = s;
        }
        return res.toString();

    }

    //递归
    public String countAndSay2(int n){
        if (n == 1){
            return "1";
        }
        String s = countAndSay2(n-1);
        StringBuffer res = new StringBuffer();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(start)){
                res.append(i-start).append(s.charAt(start));
                start = i;
            }
        }
        res.append(s.length() - start).append(s.charAt(start));
        return res.toString();
    }
}
