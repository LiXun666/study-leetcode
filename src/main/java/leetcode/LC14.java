package leetcode;


/**
 * @Author:lx
 * @Date: 2021/3/15 22:01
 * @Description:
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LC14 {
    //纵向遍历，把strs[0]当作基准
    //指针每指向strs[0]的一个字符时，遍历所有strs[i]的该位置的数，
    // 如果遇见不相同的或者index等于了该strs[i]的长度，则需要返回之前的数
    // 时间复杂O(m*n) strs的个数和每个的长度
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs == null){
            return "";
        }
        int index = 0;
        while (index < strs[0].length()){
            char c = strs[0].charAt(index);
            for (int i = 1; i<strs.length; i++){
                if (index == strs[i].length() || c != strs[i].charAt(index)){
                    return strs[0].substring(0,index);
                }
            }
            index++;
        }
        return strs[0];
    }

    //横向便利
    //遍历前一个和后一个两个字符串的公共部分，更新整个res
    // 时间复杂O(m*n) strs的个数和每个的长度
    public String longestCommonPrefix1(String[] strs){
        if(strs.length==0 || strs == null){
            return "";
        }
        String res = strs[0];
        for (int i = 1; i<strs.length; i++){
            res = findCommon(res,strs[i]);
            if (res.length() ==0){
                break;
            }
        }
        return res;

    }
    public String findCommon(String s1, String s2){

        int index = 0;
        while ((index < Math.min(s1.length(),s2.length()) ) && s1.charAt(index) == s2.charAt(index) ){
            index++;
        }
        return s1.substring(0,index);
    }
}
