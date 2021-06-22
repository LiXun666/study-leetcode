package leetcode;

/**
 * @Author:lx
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Date: 2020/11/19 13:39
 * @Description:
 */
public class LC283 {
    //双指针，right:指向之后未处理的数组第一个
    //left指向已处理数组的最后一个，每次交换后先left指向处理的最后一个，right在先后移动一个
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        while(right<length){
            if (nums[right] != 0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int l, int r){
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }

    //双指针
    //j记录非0元素每遇到非零的元素就向右移动一位，当i遍历完时，j剩下的都是0；
    public void moveZeroes2(int[] nums){
        int length = nums.length;
        int j = 0;
        for (int i =0; i<length; i++){
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
