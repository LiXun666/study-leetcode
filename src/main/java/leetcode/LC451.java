package leetcode;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-03 10:12
 * @Description
 * 根据字符出现频率排序
 */
public class LC451 {
    public static void main(String[] args) {
        String s = "abccd";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        //搞个map
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //把map的key转换成list，根据map的数值给list进行排序
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            int fre = map.get(character);
            for (int j = 0; j < fre; j++) {
                sb.append(character);
            }
        }
        return sb.toString();
    }
}
