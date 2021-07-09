package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lxjj
 * @Date 2021-07-09 10:22
 * @Description <程序员面试金典>
 * 主要元素
 */
public class LC17_10 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,4};
        majorityElement2(nums);
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        int maxcount = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > maxcount) {
                maxcount = map.get(num);
                max = num;
            }
        }
        return maxcount * 2 > n ? max : -1;
    }

    //投票
    public static int majorityElement2(int[] nums){
        int candition = nums[0], count = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == candition){
                count++;
            }else{
                count--;
                if (count == 0){
                    candition = nums[i];
                    count++;
                }
            }
        }
        count=0;
        for (int num : nums) {
            if (num == candition) count++;
        }

        return count*2>n ? candition:-1;
    }
}
