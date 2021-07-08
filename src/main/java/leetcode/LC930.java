package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lxjj
 * @Date 2021-07-08 10:47
 * @Description 和相同的二元子数组
 */
public class LC930 {
    //连续的子数组，动态规划,超时
    public int numSubarraysWithSum(int[] nums, int goal) {
        //dp[i][j]，i开始，j结束的和
        int n = nums.length;
        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = nums[j];
                } else {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
                if (dp[i][j] > goal) break;
                if (dp[i][j] == goal) res++;
            }
        }
        return res;
    }

    //hashmap法，goal=sum(j)-sum(i)
    public int numSubarraysWithSum2(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
        }
        return res;
    }

    //滑动窗口
    public int numSubarraysWithSum3(int[] nums, int goal) {
        int left1 = 0, left2 = 0, right = 0;
        int n = nums.length;
        int sum1 = 0, sum2 = 0;
        int res = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            res += left2 - left1;
            right++;
        }
        return res;
    }
    //模拟数组
    public int numSubarraysWithSum4(int[] nums, int goal){
        int[] count = new int[nums.length + 1];
        int res= 0;
        int sum =0;
        for (int num : nums) {
            count[sum]++;
            sum += num;

            if (sum - goal >=0){
                res += count[sum-goal];
            }
        }
        return res;
    }

}
