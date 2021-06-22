package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:lx
 * @Date: 2021/3/22 15:36
 * @Description:
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LC17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0){
            return res;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(res, map, digits, 0, new StringBuffer());
        return res;
    }

    public void backtrack(List<String> res, HashMap<Character, String> map, String digits, int index, StringBuffer ans){
        if (index == digits.length()){
            res.add(ans.toString());
        }else{
            char ch = digits.charAt(index);
            String letters = map.get(ch);
            for (int i = 0; i < letters.length(); i++){
                ans.append(letters.charAt(i));
                backtrack(res,map,digits,index+1,ans);
                ans.deleteCharAt(index);
            }
        }

    }
}
