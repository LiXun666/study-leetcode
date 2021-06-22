package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lx
 * @Date: 2021/6/3 10:43
 * @Description:
 * 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 */
public class LC523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2){
            return false;
        }
        //key:前缀和，value：索引
        Map<Integer,Integer> map = new HashMap<>();
        //如果两个前缀和对k的余数相等，那么两个索引之间的就是k的倍数
        int preSum = 0;
        map.put(0,-1);
        for (int i = 0; i<nums.length; i++){
            preSum = (preSum + nums[i]) % k;
            if (map.containsKey(preSum)){
                if (i - map.get(preSum) > 1){
                    return true;
                }
            }else{
                map.put(preSum,i);
            }
        }
        return false;
    }
}
