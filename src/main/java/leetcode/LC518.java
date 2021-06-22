package leetcode;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-06-10 10:00
 * @Description 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class LC518 {
    public int change(int amount, int[] coins) {

        //dp[i]，表示金额为i时，有多少种组合
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
