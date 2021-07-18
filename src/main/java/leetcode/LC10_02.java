package leetcode;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-18 0:48
 * @Description
 */
public class LC10_02 {
    public static void main(String[] args) {
        String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<String> list = groupAnagrams(strs).get(0);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        int n = strs.length;
        for(int i = 0; i < n; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(strs[i]);
            map.put(s,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
