package newcoder;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-12 16:51
 * @Description
 */
public class NC31 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }
    //复杂了
    public static int FirstNotRepeatingChar(String str) {
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char aChar : chars) {
            if (!set.contains(aChar)){
                set.add(aChar);
                queue.add(aChar);
            }else {
                queue.remove(aChar);
            }
        }
        if (queue.isEmpty()) return -1;
        Character poll = queue.poll();
        for (int i = 0; i< chars.length; i++){
            if (chars[i] == poll) return i;
        }
        return -1;
    }
    public static int FirstNotRepeatingChar2(String str){
        int[] arr = new int[58];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'A'] == 1){
                return i;
            }
        }
        return -1;
    }
}
