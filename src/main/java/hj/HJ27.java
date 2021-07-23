package hj;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-21 15:15
 * @Description
 */
public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int N = in.nextInt();
            String[] strs = new String[N];
            for(int i = 0; i<N;i++){
                strs[i] = in.next();
            }
            String target = in.next();
            int targetPos = in.nextInt();

            List<String> list = new ArrayList();
            for(int i = 0; i < N;i++){
                if(isBro(strs[i],target)){
                    list.add(strs[i]);
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            if(list.size()>=targetPos ){
                System.out.println(list.get(targetPos-1));
            }
        }
    }
    //判断str是不是target的兄弟串
    private static boolean isBro(String str, String target){
        if(str.equals(target) || str.length() != target.length()){
            return false;
        }
        char[] strSort = str.toCharArray();
        Arrays.sort(strSort);
        char[] targetSort = target.toCharArray();
        Arrays.sort(targetSort);

        return Arrays.equals(strSort,targetSort);
    }
}
