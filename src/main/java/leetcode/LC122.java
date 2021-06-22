package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/19 14:59
 * @Description:
 * 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class LC122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //买 或者卖,
        for (int i = 1; i <n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    //如果把所以增加的全算进去，利益最大化
    public int maxProfit2(int[] prices) {
        if (prices.length <=1){
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]){
                ans+= (prices[i]-prices[i-1]);
            }
        }
        return ans;
    }
}
