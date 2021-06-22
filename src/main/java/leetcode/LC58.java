package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/15 12:49
 * @Description:
 * 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 */
public class LC58 {
    public static void main(String[] args) {
        String s= "a";
        System.out.println(lengthOfLastWord2(s));
    }
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        int n = s1.length;
        if(n == 0){
            return 0;
        }
        return s1[n-1].length();
    }
    public  static  int lengthOfLastWord2(String s){
        int end = s.length()-1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end -start;

    }
}
