package leetcode;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/3/26 14:32
 * @Description: 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(n, 0, 0, new StringBuffer(), res);

        return res;
    }

    public void backTrack(int n, int open, int close, StringBuffer str, List<String> res) {
        if (str.length() == n*2) {
            res.add(str.toString());
            return;
        }
        if (open < n){
            str.append("(");
            backTrack(n, open+1, close, str, res);
            str.deleteCharAt(str.length()-1);
        }
        if (close < open){
            str.append(")");
            backTrack(n, open, close+1, str, res);
            str.deleteCharAt(str.length()-1);
        }

    }
}
