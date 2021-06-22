package leetcode;

import java.awt.font.NumericShaper;

/**
 * @Author:lx
 * 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * @Date: 2020/11/10 13:01
 * @Description:
 */
public class LC31 {
    public static void main(String[] args) {
        int[] nums = {1,5,1};
        nextPermutation(nums);

    }
    public static void nextPermutation(int[] nums) {
        //先找到一个坐标，改坐标后面都是降序排列
        int i = nums.length-2;
        while (i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        //在这个降序排列中找到j,j为从后往前刚好大于i的数
        System.out.println(i);
        if (i>=0){
            int j = nums.length-1;
            while (j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        //如果是一个递减数列，那么则最后翻转
        reverse(nums,i+1);
    }
    public static void swap(int[] nums,int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
    public static int[] reverse(int[] nums,int start){
        int left = start;
        int right = nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }

        return nums;
    }
}
