package hj;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-08-07 10:33
 * @Description
 * //外卖员 N起始楼层，M目标楼层
 */
public class HJ8_5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N==M){
            System.out.println(0);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(N);
        set.add(N);
        int size = 0;
        int minutes = 0;
        while (!queue.isEmpty()){
            size = queue.size();

            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                if (poll == M){
                    System.out.println(minutes);
                }else{
                    int N1 = poll+1;
                    int N2 = poll-1;
                    int N3 = poll<<2;
                    if (!set.contains(N1) && isvaild(N1)){
                        queue.add(N1);
                        set.add(N1);
                    }
                    if (!set.contains(N2) && isvaild(N2)){
                        queue.add(N2);
                        set.add(N2);
                    }
                    if (!set.contains(N3) && isvaild(N3)){
                        queue.add(N3);
                        set.add(N3);
                    }
                }
            }
            minutes++;
        }
    }

    private static boolean isvaild(int N) {
        if (N>=0&&N<=100000){
            return true;
        }

        return false;
    }
}
