package leetcode;

import java.util.TreeSet;

/**
 * @Author:lx
 * @Date: 2021/4/17 9:01
 * @Description:
 */
public class LC220 {
    public static void main(String[] args) {
        int[] nums = {-2147483648,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 1));
    }
    //滑动窗口
    //从nums[0]开始，每次看k个，在k个中遍历如果找到了 就返回
    //如果没找到继续向下，直到i+k<len
    //需要优化，优化的是查找的过程
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return false;
        }
        int index = 0;
        while (index <len) {
            for (int i = index + 1; i < len && i <= index + k; i++) {
                if (Math.abs((long) nums[index] - nums[i]) <= t) {
                    return true;
                }
            }
            if (index+k == len){

            }
            index++;
        }
        return false;
    }

    //滑动窗口+有序集合
    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t){
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

}
