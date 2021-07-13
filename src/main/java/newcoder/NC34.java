package newcoder;

import java.util.Arrays;

/**
 * @Author lxjj
 * @Date 2021-07-13 9:36
 * @Description 求路径
 */
public class NC34 {

    //动态规划
    public int uniquePaths(int m, int n) {
        //do[i][j],i,j位置有多少种走法
        int[][] dp = new int[m + 1][n + 1];
        //i=1,j=1全是0
        Arrays.fill(dp[1], 1);
        for (int i = 1; i < m + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    //数学方法，走到m，n共有n+m-2步 C(n+m-2, n-1)
    public int uniquePaths2(int m, int n) {
        int sum = m + n - 2;
        int r = n - 1;
        double res = 1.0;
        for (int i = 1; i <= r; i++) {
            res = res * (sum - r + i) / i;
        }
        return (int) res;
    }

}
