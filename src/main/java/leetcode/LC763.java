package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * 划分字母区间：
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * @Date: 2020/10/22 11:14
 * @Description:
 */
public class LC763 {
    /**
     * 思路：
     * 1.先创建个数组，存放每个字母最后出现的下标位置，
     * 2.遍历S,比较每个字母最后出现的位置，取最大的
     * 3.当i==end时，证明这些字符串都在该字符串中，把end-start+1放入list中
     * 4.令start=end+1，继续直到遍历完这个字符串S
     *
     */
    public List<Integer> partitionLabels(String S) {

        int[] ints = new int[26];
        //记录26个字母最后出现的下标位置
        for (int i=0;i<S.length();i++){
            ints[S.charAt(i)-'a'] = i;
        }

        List<Integer> integers = new ArrayList<Integer>();
        int start = 0,end =0;
        for (int i=0; i<S.length(); i++){
            end = Math.max(end, ints[S.charAt(i)-'a']);
            if (i == end){
                integers.add(end - start + 1);
                start = end + 1;
            }
        }
        return integers;
    }
}
