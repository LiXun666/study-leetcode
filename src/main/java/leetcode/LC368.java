package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/4/23 14:37
 * @Description: 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 */
public class LC368 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        largestDivisibleSubset(nums);

    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxSize = 1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i] > maxSize){
                maxSize=dp[i];
                maxIndex = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = maxIndex; i >= 0 && maxSize >0; i--) {
            if (dp[i] == maxSize && nums[maxIndex]%nums[i] == 0){
                res.add(nums[i]);
                maxSize--;
                maxIndex = i;

            }
        }
        return res;
    }
}
