package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lx
 * @Date: 2021/6/3 11:44
 * @Description:
 */
public class LC525 {

    //超时
    public int findMaxLength(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i+1] = nums[i]+dp[i];
        }
        //nums变成前缀和
        //如果相等的话， index2 - index1 / nums[index2] -nums[index1]==2
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            int n = dp[i];
            for (int j = i+2; j <dp.length; j+=2) {
                if((dp[j] -dp[i]) * 2 == j-i){
                    max = Math.max(max,j-i);
                }
            }
        }
        return max;
    }

    //加入hashmap
    public int findMaxLength2(int[] nums){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                count++;
            }else{
                count--;
            }

            if (map.containsKey(count)){
                res = Math.max(res,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return res;
    }

}
