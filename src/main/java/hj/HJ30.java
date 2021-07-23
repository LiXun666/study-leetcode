package hj;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-21 17:46
 * @Description
 */
public class HJ30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str1 = in.next();
            String str2 = in.next();
            String s = str1+str2;
            int len = s.length();
            List<Character> evens = new ArrayList<>();
            List<Character> odds = new ArrayList<>();
            for(int i = 0;i<len;i++){
                if(i%2 == 0){
                    evens.add(s.charAt(i));
                }else{
                    odds.add(s.charAt(i));
                }
            }
            Collections.sort(evens);
            Collections.sort(odds);
            Map<Character,Character> map = new HashMap<Character,Character>(){{
                put('0', '0');
                put('1', '8');
                put('2', '4');
                put('3', 'C');
                put('4', '2');
                put('5', 'A');
                put('6', '6');
                put('7', 'E');
                put('8', '1');
                put('9', '9');
                put('a', '5');
                put('b', 'D');
                put('c', '3');
                put('d', 'B');
                put('e', '7');
                put('f', 'F');
                put('A', '5');
                put('B', 'D');
                put('C', '3');
                put('D', 'B');
                put('E', '7');
                put('F', 'F');
            }};
            for(int i = 0; i < odds.size();i++){
                char even = evens.get(i);
                char odd = odds.get(i);
                if(Character.isDigit(even)
                        || (even>='A'&&even<='F') || (even>='a'&&even<='f')){
                    System.out.print(map.get(even));
                }else{
                    System.out.print(even);
                }
                if(Character.isDigit(odd)
                        || (odd>='A'&&odd<='F') || (odd>='a'&&odd<='f')){
                    System.out.print(map.get(odd));
                }else{
                    System.out.print(odd);
                }
            }
            if(odds.size() < evens.size()){
                char pos = evens.get(evens.size()-1);
                if(Character.isDigit(pos)
                        || (pos>='A'&&pos<='F') || (pos>='a'&&pos<='f')){
                    System.out.print(map.get(pos));
                }else{
                    System.out.print(pos);
                }
            }
            System.out.println();
        }
    }
}
