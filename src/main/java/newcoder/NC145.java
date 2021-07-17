package newcoder;

/**
 * @Author lxjj
 * @Date 2021-07-17 10:09
 * @Description 01背包
 */
public class NC145 {
    public int knapsack(int V, int n, int[][] vw) {
        // write code here
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                //第i个物体的体积，和重量
                int vi = vw[i - 1][0];
                int wi = vw[i - 1][1];
                if (vi > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vi] + wi);
                }

            }
        }
        return dp[n][V];
    }

    //一维优化
    public int knapsack2(int V, int n, int[][] vw) {
        //容量为j时的最大重量
        int[] dp = new int[V + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = V; j >= vw[i - 1][0]; j--) {
                dp[j] = Math.max(dp[j - vw[i - 1][0]] + vw[i - 1][1], dp[j]);
            }
        }
        return dp[V];
    }

    //完全背包
    public int perfectBag(int V, int n, int[][] vw) {
        //容量为j时的最大重量
        int[][] dp = new int[n+1][V+1];
        for(int i = 1; i<=n; i++){
            for(int j = 0; j <=V; j++){
                for(int k = 0; k*vw[i-1][0] <= j;k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j- k*vw[i-1][0]]+k*vw[i-1][1]);
                }

            }
        }
        return dp[n][V];
    }

    //完全背包 一维优化
    public int perfectBag2(int V, int n, int[][] vw){
        int[] dp = new int[V+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = vw[i-1][0]; j <=V ; j++) {
                dp[j] = Math.max(dp[j], dp[j-vw[i-1][0]]+vw[i-1][1]);
            }
        }
        return dp[V];
    }
}
