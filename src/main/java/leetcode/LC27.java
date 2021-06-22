package leetcode;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/4/2 13:42
 * @Description:
 * 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class LC27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        removeElement(nums,3);
    }
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return nums.length;
        }
        Arrays.sort(nums);
        int start = 0;
        int end  = 0;
        for(int i = 0; i <nums.length; i++){
            if(nums[i] == val){
                for(int j = i; j<nums.length; j++){
                    if(nums[j] == val){
                        end = j;
                        continue;
                    }
                    break;
                }
                start = i;
                break;
            }
            return nums.length;
        }
        for(int i = 0; i < nums.length - end-1;i++){
            nums[start+i] = nums[end+1+i];
        }
        return nums.length-end+start-1;
    }

    //双指针
    public static int removeElement2(int[] nums, int val){
        int left = 0,right = nums.length-1;
        //确保right后面的指针都等于val
        while ( right>0 && nums[right] == val ){
            right--;
        }
        if (right <= 0){
            return 0;
        }
        while(left<right){
            if (nums[left] == val){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
            while ( nums[right] == val ){
                right--;
            }
            left++;
        }
        return right+1;
    }
    //双指针
    public static int removeElement3(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    //双指针
    public static int removeElement4(int[] nums, int val){
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
