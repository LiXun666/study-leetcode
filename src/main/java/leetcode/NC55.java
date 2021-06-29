package leetcode;

/**
 * @Author lxjj
 * @Date 2021-06-29 11:30
 * @Description
 */
public class NC55 {
    public static void main(String[] args) {
        String[] strs = new String[]{"abca","abc","abca","abc","abcc"};
        longestCommonPrefix(strs);
    }
    public static String longestCommonPrefix(String[] strs) {
        // write code here
        if(strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() < i+1){
                    return res.toString();
                }else
                if(strs[j].charAt(i) != c){
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();

    }
}
