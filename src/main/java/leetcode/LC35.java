package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/6 11:24
 * @Description:
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <right){
            int center = (left + right)/2;
            if (nums[center] >= target){
                right = center;
            }else if (nums[center] < target){
                left = center+1;
            }
        }
        return left;
    }
}
