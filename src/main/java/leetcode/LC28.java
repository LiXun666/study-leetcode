package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/2 14:21
 * @Description:
 * 实现 strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 */
public class LC28 {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0 || needle == " "){
            return 0;
        }
        char[] source =  haystack.toCharArray();
        char[] target = needle.toCharArray();
        int sourcelength = source.length;
        int targetlength = target.length;
        for(int i = 0; i < sourcelength-targetlength+1;i++){
            if(source[i] == target[0]){
                int k;
                for(k = 0; k<targetlength; k++){
                    if(source[i+k] != target[k]) break;
                }
                if(k == targetlength){
                    return i;
                }
            }
        }

        return -1;
    }
    public int strStr2(String haystack, String needle){
        int hlength = haystack.length();
        int nlength = needle.length();
        for (int i = 0; i < hlength-nlength+1;i++){
            if (haystack.substring(i,i+nlength).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
