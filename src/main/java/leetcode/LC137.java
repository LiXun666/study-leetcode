package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lx
 * @Date: 2021/4/30 11:27
 * @Description:
 * 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class LC137 {
    //暴力+排序
    public int singleNumber(int[] nums) {
        if (nums.length < 2){
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0]!=nums[1]){
            return nums[0];
        }
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    //hashmap()
    public int singleNumber2(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
