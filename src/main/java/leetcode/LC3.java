package leetcode;

import java.util.HashSet;

/**
 * @Author:lx
 * @Date: 2021/3/4 15:43
 * @Description: 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 思路:
 * 1.遍历整个s的长度,找到以每个位置作为开始的子串的最大长度
 * 2.移动到新的起点时，首先应该删除前一个字母，在将r(右边的指针)向有移动，直到找到set中重复的。
 * 3.每次找到该起点子串的最大长度后就更新ans的值。
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> sets = new HashSet<>();
        int ans = 0;
        int r = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //每次移除前一个字符
                sets.remove(s.charAt(i - 1));
            }
            //找到以i为起点的最长字串
            while (r + 1 < n && !sets.contains(s.charAt(r + 1))) {
                sets.add(s.charAt(r + 1));
                r++;
            }

            ans = Math.max(ans, r - i + 1);
        }
        return ans;
    }

}
