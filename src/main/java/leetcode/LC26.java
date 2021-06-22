package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/2 16:09
 * @Description:
 * 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2 ){
            return nums.length;
        }
        int n = nums.length;
        int j = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }else{
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
