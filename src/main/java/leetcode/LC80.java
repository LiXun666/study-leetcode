package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/6 10:56
 * @Description:
 * 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 */
public class LC80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]){
                nums[index] = nums[i];
                index++;
                while (i+1<n&&nums[i+1] == nums[i]){
                    i++;
                }
            }else{
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
