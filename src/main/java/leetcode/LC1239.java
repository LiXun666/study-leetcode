package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lxjj
 * @Date 2021-06-19 11:08
 * @Description 串联字符串的最大长度
 */
public class LC1239 {
    //回溯+位运算
    int ans = 0;

    public int maxLength(List<String> arr) {
        //masks
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                //如果包含这个字符，那么mask置为0，不要这个s
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                //如果不包含，那么把第ch位变成1
                mask |= 1 << ch;
            }
            if(mask > 0){
                masks.add(mask);
            }
        }
        //至此masks代表arr中不含重复字符组成的集合
        backTrack(masks, 0, 0);
        return ans;
    }

    /**
     *
     * @param masks 需要遍历的集合
     * @param pos 当前遍历的位置
     * @param mask 目前满足答案要求的结果
     */
    private void backTrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()){
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        //如果mask跟masks中的一个数&为0，那么两个没有任何公共元素
        if ((mask & masks.get(pos)) == 0) {
            backTrack(masks, pos+1, mask | masks.get(pos));
        }
        backTrack(masks, pos+1, mask);
    }
}
