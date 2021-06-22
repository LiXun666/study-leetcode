package zjoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lxjj
 * @Date 2021-06-22 9:48
 * @Description
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class ZJ38 {
    List<String> res;
    boolean[] vis;
    public String[] permutation(String s) {
        res = new ArrayList<>();
        int n = s.length();
        vis = new boolean[n];
            char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backTrack(chars,0,n,new StringBuilder());

        return res.toArray(new String[res.size()]);
    }

    private void backTrack(char[] chars, int i, int n, StringBuilder sb) {
        if (i == n){
            res.add(sb.toString());
            return;
        }
        //每个字符串的长度为n，故循环
        for (int j = 0; j < n; j++){
            //确保该位置已经被占了，如果j-1被访问过，j和j-1又是同一个字符 ，那么这个位置j就不要再放了 两种情况都直接继续
            if (vis[j] || (j>0 && chars[j-1] == chars[i] && vis[j-1])) continue;
            vis[j] = true;
            sb.append(chars[j]);
            backTrack(chars,i+1,n,sb);
            sb.deleteCharAt(sb.length()-1);
            vis[j] = false;
        }

    }
}
