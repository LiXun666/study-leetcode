package newcoder;

/**
 * @Author lxjj
 * @Date 2021-07-05 16:57
 * @Description 买卖股票的最好时机
 */
public class NC7 {
    //暴力解法
    public int maxProfit(int[] prices) {
        // write code here
        int ans = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] - prices[i] < 0) continue;
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }

    //贪心
    //最便宜的时候买，现在这个价格卖
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int minVal = prices[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        return ans;
    }

    //动态规划
    //dp[i][2]，
    // dp[i][0]，第i天未持有股票 = max{dp[i-1][1]+prices[i], dp[i][0]}
    //dp[i][1], 第i天持有股票 = max{dp[i-1][1], -prices[i]}，尽量选择一个更便宜的股票持有
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //第一天
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }
}
