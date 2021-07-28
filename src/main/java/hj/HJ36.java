package hj;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-27 17:54
 * @Description
 */
public class HJ36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String key = sc.nextLine();
            String code = sc.nextLine();
            Set<Character> set = new HashSet();
            char[] arr = new char[26];
            char c = 'a';
            //制作对照表
            int in = 0;
            for (int i = 0; i < key.length(); i++) {
                char ch = Character.toLowerCase(key.charAt(i));
                if (!set.contains(ch)) {
                    set.add(ch);
                    arr[in] = ch;
                    in++;
                }
            }
            for (int i = in; i < 26; i++) {
                while (set.contains(c)) {
                    c = (char) (c + 1);
                }
                set.add(c);
                arr[i] = c;
            }
            //遍历code将其加密
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                int index = Character.toLowerCase(code.charAt(i)) - 'a';

                if (code.charAt(i) >= 'a' && code.charAt(i) <= 'z') {
                    sb.append(arr[index]);
                } else {
                    sb.append(Character.toUpperCase(arr[index]));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
