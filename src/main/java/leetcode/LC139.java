package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author:lx
 * @Date: 2021/6/3 17:23
 * @Description:
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //hashset判断是否存在
        Set<String> set = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++){
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
