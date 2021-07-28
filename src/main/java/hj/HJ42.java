package hj;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-28 14:42
 * @Description
 */
public class HJ42 {
    private static Map<Integer, String> map = new HashMap(){
        {
            put(1,"one");put(2,"two");put(3,"three");put(4,"four");
            put(5,"five");put(6,"six");put(7,"seven");put(8,"eight");put(9,"nine");
            put(10,"ten");put(11,"eleven");put(12,"twelve");put(13,"thirteen");put(14,"fourteen");
            put(15,"fifteen");put(16,"sixteen");put(17,"seventeen");put(18,"eighteen");put(19,"nineteen");
            put(20,"twenty");put(30,"thirty");put(40,"forty");put(50,"fifty");put(60,"sixty");put(70,"seventy");
            put(80,"eighty");put(90,"ninety");
        }

    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            long a = in.nextInt();
            List<String> res = new ArrayList<>();
            int count = 0;
            while (a > 0){
                res.addAll(process((int)a%1000));
                a /= 1000;
                if (a==0) break;
                if (count==0){
                    res.add("thousand");
                }
                if (count==1){
                    res.add("million");
                }
                if(count==2){
                    res.add("billion");
                }
                count++;
            }
            for (int i = res.size()-1;i>=0;i--){
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
    }

    //如果l是一个1位数直接找，如果l是一个两位直接找，如果是一个三位数中间加end
    private static List<String> process(int l) {
        List<String> temp =  new ArrayList<>();
        int a = l%100;
        if (a>0 && a<20){
            temp.add(map.get(a));
        }else if (a>=20){
            int g = a %10;
            int s = a-g;
            if (g !=0){
                temp.add(map.get(g));
            }
            temp.add(map.get(s));
        }
        int b = l/100;
        if (b!=0){
            temp.add("and");
            temp.add("hundred");
            temp.add(map.get(b));
        }
        return temp;
    }
}
