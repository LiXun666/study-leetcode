package leetcode;

import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/9 11:32
 * @Description:
 *  删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class LC1047 {
    public String removeDuplicates(String S) {
        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < S.length(); i++){
//            if (sb.length() > 0 && S.charAt(i) == sb.charAt(sb.length()-1)){
//                sb.deleteCharAt(sb.length()-1);
//            }else{
//                sb.append(S.charAt(i));
//            }
//        }

        int top = -1;
        for (int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
           if (top>=0 && sb.charAt(top) == ch){
               sb.deleteCharAt(top);
               top--;
           }else {
               sb.append(ch);
               top++;
           }
        }
        return sb.toString();

    }

    //不使用stringbuffer
    public String removeDuplicates1(String S){
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < s.length; i++){
            if (top == -1 || s[top] != s[i]){
                s[++top] = s[i];
            }else{
                top--;
            }
        }
        return String.valueOf(s,0,top +1);
    }
}
