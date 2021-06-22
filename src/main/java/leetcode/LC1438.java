package leetcode;

import java.util.ArrayDeque;
import java.util.TreeMap;

/**
 * @author: liuhj
 * @Date: 2021/2/21 8:53
 * Description:
 * 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，
 * 请你返回最长连续子数组的长度，
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 */
public class LC1438 {

    //滑动窗口+ 有序集合treemap
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0;
        int ans = 0;

        //treemap中的key是有序排列的，降序
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    //滑动窗口
    public int longestSubarray2(int[] nums, int limit) {
        int right = 0, left = 0, ans = 0;
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> minQueue = new ArrayDeque<>();
        while(right < nums.length){
            while (!maxQueue.isEmpty() && nums[right] > maxQueue.peekLast()){
                maxQueue.removeLast();
            }
            while (!minQueue.isEmpty() && nums[right] < minQueue.peekLast()){
                minQueue.removeLast();
            }
            maxQueue.add(nums[right]);
            minQueue.add(nums[right]);
            right++;

            while (maxQueue.peek() - minQueue.peek() >limit){
                if (maxQueue.peek() == nums[left]) {
                    maxQueue.remove();
                }
                if (minQueue.peek() == nums[left]){
                    minQueue.remove();
                }
                left++;
            }

            ans = Math.max(ans,right - left);
        }
        return ans;
    }
}
