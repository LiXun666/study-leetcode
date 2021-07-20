package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author lxjj
 * @Date 2021-07-19 23:36
 * @Description
 */
public class LC1838 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(5);
        set.add(4);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 0;
        int total = 0;
        while (right < n) {
            int max = nums[right];
            total += nums[right];
            right++;
            if (max * (right - left) - total > k) {
                total -= nums[left++];
            }
        }
        return right - left;
    }

    public static int maxFrequency2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 0, total = 0;
        int max = 0;
        while (right < n){
            total += (right-left)*(nums[right]- nums[right-1]);

            if (total > k){
                total -= (nums[right]-nums[left++]);
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
