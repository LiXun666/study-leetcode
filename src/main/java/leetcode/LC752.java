package leetcode;

import java.io.StringReader;
import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-26 23:54
 * @Description
 */
public class LC752 {
    public static void main(String[] args) {
        String[] strings = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(strings, "0202"));
    }
    //bfs
    public static int openLock(String[] deadends, String target) {
        //为了去重把deadends放入一个set
        if ("0000".equals(target)) return 0;
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        if (deadSet.contains("0000")) return -1;
        Set<String> seenSet = new HashSet<>();
        seenSet.add("0000");
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            //枚举所有可能变成的密码，如果set中不存在就加入
            for (int i = 0; i< size;i++){
                String cur = queue.poll();
                List<String> list =  getNum(cur);
                for (String s : list) {
                    if (!deadSet.contains(s) && !seenSet.contains(s)){
                        if (s.equals(target)){
                            return step;
                        }
                        seenSet.add(s);
                        queue.offer(s);
                    }
                }
            }
        }
        return -1;
    }

    private static List<String> getNum(String cur) {
        List<String> list = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = chars[i];
            chars[i] = preNum(c);
            list.add(new String(chars));
            chars[i] = postNum(c);
            list.add(new String(chars));
            chars[i] = c;
        }
        return list;
    }

    private static char postNum(char c) {
        return c=='9'?'0':(char)(c+1);
    }

    private static char preNum(char c) {
        return c=='0'?'9':(char)(c-1);
    }
}
