package leetcode;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/3/5 11:36
 * @Description: 最长递增子序列
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LC300 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        lengthOfLIS1(nums);
    }
    //动态规划
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int ans = 1;
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    f[i] = Math.max(f[i] , f[j]+1);
                }
            }
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }

    //动态规划+二分查找
    public static int lengthOfLIS1(int[] nums){
            int[] tails = new int[nums.length];
            int res = 0;
            for(int num : nums) {
                int i = 0, j = res;
                while(i < j) {
                    int m = (i + j) / 2;
                    if(tails[m] < num) i = m + 1;
                    else j = m;
                }
                tails[i] = num;
                if(res == j) res++;
            }
            return res;
    }
}
