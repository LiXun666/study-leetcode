package leetcode;

/**
 * @Author lxjj
 * @Date 2021-06-09 10:02
 * @Description 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第i种工作会产生profit[i]的利润，它要求group[i]名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模10^9 + 7的值
 */
public class LC879 {

    //dp[i][j][k],i背包容量：前i个工作，j:使用了j个员工，k：利润至少为k的情况下可以盈利的总数目
    //边界条件dp[0][0][0] = 1 ，前0个工作0个员工盈利为0的情况下 就是什么都不做 1种方案
    //该方案超时
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, MOD = (int) 1e9 + 7;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            //第i个工作的需要员工数和盈利
            int member = group[i - 1], earn = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < member) {
                        //该情况下，该工作必不可能选
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        //该情况下，该工作可选可不选 两种情况加起来
                        //解释：Math.max(0,k-earn):由于需要的是盈利至少为k的情况，
                        // 当k<earn时,0+earn > k的,所以符合最少为k的条件
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - member][Math.max(0, k - earn)]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        //员工可以不用完,
        for (int j = 0; j <= n; j++) {
            //前len个工作,j个员工，min的利润
            sum += dp[len][j][minProfit] % MOD;
        }
        return sum;
    }

    /*
    优化：
    变成二维优化;
    dp[j][k],最小利润为k时，0-i个员工能有多少种盈利方案的总数
    dp[i][0] = 1,因为最小利润为0时，无论多少员工工作 都至少有一种方案
     */
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            //第i个工作的需要员工数和盈利
            int member = group[i - 1], earn = profit[i - 1];
            for (int j = n; j >= member; j--) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[j][k] = (dp[j][k] + dp[j - member][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }

    /*
    二维：
    dp[j][k],最小利润为k时，刚好为j个员工能有多少种盈利方案的数，最后需要把从0-n个加起来
     */
    public int profitableSchemes3(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_000 + 7;

        int N = group.length;

        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            int g = group[i];
            int p = profit[i];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] += dp[j - g][Math.max(k - p, 0)];
                    if (dp[j][k] > MOD) {
                        dp[j][k] -= MOD;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += dp[i][minProfit];
            if (sum > MOD) {
                sum -= MOD;
            }
        }

        return sum;
    }
}
