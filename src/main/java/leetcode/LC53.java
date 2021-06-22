package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/12 16:41
 * @Description:
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class LC53 {
    public int maxSubArray(int[] nums) {
        //dp[i]表示以第i个为结尾的连续数组的最大值
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp[i-1] > nums[i]){
                dp[i] = dp[i-1]+nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
