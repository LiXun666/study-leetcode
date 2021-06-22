package leetcode;

import java.util.Arrays;

/**
 * @Author lxjj
 * @Date 2021-06-10 9:51
 * @Description
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        //金额为i时，需要最少的硬币
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        if (dp[amount] == amount+1){
            return -1;
        }
        return dp[amount];
    }
}
