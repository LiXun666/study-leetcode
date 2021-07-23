package hj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author lxjj
 * @Date 2021-07-20 23:50
 * @Description
 * 数据分类处理
 */
public class HJ25 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int lenI = sc.nextInt();
//            int[] I = new int[lenI];
//            for (int i = 0; i < lenI; i++) {
//                I[i] = sc.nextInt();
//            }
//            int lenR = sc.nextInt();
//            int[] R = new int[lenR];
//            for (int i = 0; i < lenR; i++) {
//                R[i] = sc.nextInt();
//            }
//            Arrays.sort(R);
//            int[] times = new int[lenR];
//            int sum = 0;
//            for (int i = 0; i < lenR; i++) {
//                if (i>0 && R[i] == R[i-1]){
//                    continue;
//                }else{
//                    for (int j = 0; j < lenI; j++) {
//                        if (String.valueOf(I[j]).contains(String.valueOf(R[i]))){
//                            times[i]++;
//                        }
//                    }
//                    sum += times[i]+1;
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            sb.append(sum*2+" ");
//            for (int i = 0; i < lenR; i++) {
//                if (times[i] == 0) continue;
//                sb.append(R[i]+" ");
//                sb.append(times[i]+" ");
//                for (int j = 0; j < lenI; j++) {
//                    if (String.valueOf(I[j]).contains(String.valueOf(R[i]))){
//                        sb.append(j+" ");
//                        sb.append(I[j]+" ");
//                    }
//                }
//            }
//            System.out.println(sb.toString().substring(0,sb.length()-1));
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            //输入I序列
            int lenI = in.nextInt();
            int[] I = new int[lenI];
            for(int i = 0; i<lenI; i++){
                I[i] = in.nextInt();
            }
            //输入R序列
            int lenR = in.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap();
            for(int i = 0; i<lenR; i++){
                int a = in.nextInt();
                if(!map.containsKey(a)){
                    map.put(a,0);
                }
            }
            int sum = 0;
            int[] times = new int[map.size()];
            for(int r : map.keySet()){
                //判断是否有该数
                int count = 0;
                for(int i = 0; i<lenI;i++){
                    if(String.valueOf(I[i]).contains(String.valueOf(r))){
                        count++;
                    }
                }
                if(count > 0) {
                    sum += count+1;
                    map.put(r,count);
                }
            }
            sum = sum*2;
            StringBuilder sb = new StringBuilder();
            sb.append(sum+" ");
            for(int r : map.keySet()){
                if(map.get(r) != 0){
                    sb.append(r+" ");
                    sb.append(map.get(r)+" ");
                    for(int i = 0; i< lenI;i++){
                        if(String.valueOf(I[i]).contains(String.valueOf(r))){
                            sb.append(i+" ");
                            sb.append(I[i]+" ");
                        }
                    }
                }
            }
            System.out.println(sb.toString().substring(0,sb.length()-1));
        }
    }
}
