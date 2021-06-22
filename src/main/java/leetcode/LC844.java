package leetcode;

import sun.security.util.Length;

/**
 * @Description TODO
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * @Date 2020/10/19 10:33
 * @Created by lx
 */
public class LC844 {
    public boolean backspaceCompare(String S, String T) {

        return build(S).equals(build(T));
    }

    //将给定的字符串中的退格符和应当被删除的字符都去除，还原给定字符串的一般形式。然后直接比较两字符串是否相等即可。
    //如果它是退格符，那么我们将栈顶弹出；
    //如果它是普通字符，那么我们将其压入栈中。
    public String build(String X){
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = X.toCharArray();
        for (int i = 0; i<chars.length; i++){
            if (chars[i] != '#'){
                stringBuffer.append(chars[i]);
            }else if(stringBuffer.length()>0){
                stringBuffer.deleteCharAt(stringBuffer.length()-1);}
        }
        return stringBuffer.toString();
    }


}
