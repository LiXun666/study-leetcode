package leetcode;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @Author:lx
 * 下一个排列
 *  *
 *  * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *  *
 *  * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *  *
 *  * 必须原地修改，只允许使用额外常数空间。
 * @Date: 2020/11/11 10:52
 * @Description:
 */
public class LC31test {
    //从后往前找到降序的一段
    public void nextPermutation(int[] nums){
        int i = nums.length-2;
        //i之后全是递减
        while (i>=0 && nums[i]>nums[i+1]){
            i--;
        }
        //找到j,互换j
        int j = nums.length -1 ;
        if (i>=0){
            while (j >= 0 && nums[i] > nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);

    }
    //把坐标i,j互换
    public void swap(int[] nums,int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
    public int[] reverse(int[] nums,int start){
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
