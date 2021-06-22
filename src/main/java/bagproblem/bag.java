package bagproblem;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-06-08 15:08
 * @Description
 */
public class bag {


    public static void main(String[] args) {
        //定义键盘输入
        Scanner sc = new Scanner(System.in);
        //N表示物品个数
        System.out.println("请输入N,V:");
        int N = sc.nextInt();
        //V表示背包容量
        int V = sc.nextInt();
        // i 件物品的体积
        System.out.println("请输入v,w");
        int[] v = new int[N + 1];
        // i 件物品的价值
        int[] w = new int[N + 1];
        //给物品赋值
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(zeroOneBag(N, V, v, w));
    }

    /*0-1背包问题
    有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
    第 i 件物品的体积是 vi，价值是 wi。
    求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
    输出最大价值。
     */
    //1维
    public static int zeroOneBag(int N, int V, int[] v, int[] w) {
        //f[i]，表示前i个物品，最大的价值
        int[] f = new int[V + 1];
        f[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        return f[V];
    }

    //2维
    public static int zeroOneBag2(int N, int V, int[] v, int[] w) {
        //表示前i个数量，体积为j时最大的价值
        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        return dp[N][V];
    }

    //完全背包问题 ,物品使用次数无限制
    public static int completeBag(int N, int V, int[] v, int[] w) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }

    //多重背包1, 每个物品有s的限制
    public static int multipleBag(int N, int V, int[] v, int[] w, int[] s) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }
}
