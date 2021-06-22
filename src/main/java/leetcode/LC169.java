package leetcode;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/4/26 14:23
 * @Description:
 */
public class LC169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement2(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right){
            int low = left,high = right;
            int stard = nums[left];
            while (low < high){
                while (low < high && nums[high]>=stard){
                    high--;
                }
                if (low < high){
                    nums[low++] = nums[high];
                }
                while(low < high && nums[low] <= stard){
                    low++;
                }
                if (low<high){
                    nums[high--] = nums[low];
                }
            }
            nums[left] = stard;
            quickSort(nums,left,low-1);
            quickSort(nums,low+1,right);
        }
    }
    //投票发
    public int majorityElement3(int[] nums){
        int count = 1;
        int candidant = nums[0];
        for (int i = 1; i <nums.length; i++) {
            if (nums[i] == candidant){
                count++;
            }else if (count == 0){
                candidant = nums[i];
            }else {
                count--;
            }
        }
        return candidant;
    }

}
