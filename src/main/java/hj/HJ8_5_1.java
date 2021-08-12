package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-08-04 18:45
 * @Description
 * //地理统计
 */
public class HJ8_5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int W = sc.nextInt();
            int L = sc.nextInt();
            int[][] wl = new int[L][W];
            for (int i = 0; i<L;i++){
                for (int j = 0; j<W; j++){
                    wl[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for (int i = 0; i<L;i++){
                for (int j = 0; j<W; j++){
                    ans = Math.max(ans,dfs(wl,i,j));
                }
            }
            System.out.println(ans);
        }
    }

    private static int dfs(int[][] wl, int i, int j) {
        if (i>=wl.length || j>= wl[0].length || i<0|| j<0|| wl[i][j] == 0){
            return 0;
        }
        //由于是连着的，计算过的直接归0
        int temp = wl[i][j];
        wl[i][j] = 0;
        return temp + dfs(wl,i+1,j)+ dfs(wl,i-1,j)+ dfs(wl,i,j+1)+ dfs(wl,i,j-1);
    }

}
