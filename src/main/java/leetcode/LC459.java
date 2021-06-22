package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/17 18:44
 * @Description:
 */
public class LC459 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("aba"));

    }

    //O(n) 基本就是把s遍历了一次 再加几次比较
    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1 ){
            return false;
        }
        int index = 0;

        while(++index < s.length()){
            if(s.charAt(0) == s.charAt(index)){
                if(s.length() % index != 0){
                    continue;
                }
                int n = 1;
                while((n+1) * index <= s.length()){
                    if(!s.substring(0,index).equals(s.substring(n*index,(n+1)*index))){
                        break;
                    }
                    if((n+1) * index == s.length()){
                        return true;
                    }
                    n++;
                }
            }
        }
        return false;
    }

    //kmp算法 O(n)，空间复杂度O(n)
    public static boolean repeatedSubstringPattern1(String s){
        //把S=s+s拼成一个字符串，如果s是在s+s(除去第一各字符)的一个子串的话，那么返回true
        String S = s+s;
        String des = S.substring(1,S.length()-1);
        int[] next = kmpNext(s);
        for (int i = 0, j = 0; i < des.length(); i++){
            if (j>0 && des.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }

            if (des.charAt(i) == s.charAt(j)){
                j++;
            }
            if (j == s.length()){
                return true;
            }
        }
        return false;

    }
    public static int[] kmpNext(String s){
        int[] next = new int[s.length()];
        for (int i = 1, j = 0; i < s.length(); i++) {
            if (j>0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
