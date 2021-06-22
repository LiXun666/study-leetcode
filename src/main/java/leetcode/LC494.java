package leetcode;

/**
 * @Author:lx
 * @Date: 2021/6/7 18:49
 * @Description: 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class LC494 {
    int res;

    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        //便利所有情况
        backTrack(nums, target, 0, 0);
        return res;
    }

    private void backTrack(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            if (sum == target) res++;
        } else {
            backTrack(nums, target, sum + nums[i], i + 1);
            backTrack(nums, target, sum - nums[i], i + 1);
        }
    }

    //动态规划
    public int findTargetSumWays2(int[] nums, int target) {
        //dp[i][j]，表示前i个数字中，neg为j的数量,neg表示为取减号的和
        //sums - neg - neg = target;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
