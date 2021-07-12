package newcoder;

import java.util.Arrays;

/**
 * @Author lxjj
 * @Date 2021-07-12 15:21
 * @Description 换钱的最少货币数
 */
public class NC126 {
    public int minMoney(int[] arr, int aim) {
        // write code here
        //dp[i]，凑够i需要多少钱
        int[] dp = new int[aim + 1];
        //最多都要是aim张
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for (int i = 0; i < aim + 1; i++) {
            for (int k : arr) {
                if (i - k >= 0) dp[i] = Math.min(dp[i], dp[i - k] + 1);
            }
        }
        return dp[aim] == aim + 1 ? -1 : dp[aim];
    }
}
