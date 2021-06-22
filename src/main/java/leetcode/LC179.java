package leetcode;

import datastructure.sort.QuickSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author:lx
 * @Date: 2021/4/12 13:43
 * @Description: 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 */
public class LC179 {
    public static void main(String[] args) {
        int[] nums = {30, 3, 34, 5, 9};
        String s = largestNumber2(nums);
        System.out.println(s);
    }

    //使用系统比较器
    public static String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (o1, o2) -> {
            long sx = 10, sy = 10;
            while (sx <= o1) {
                sx *= 10;
            }
            while (sy <= o2) {
                sy *= 10;
            }
            return (int) (sx * o2 + o1 - sy * o1 - o2);

        });
        if (arr[0] == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }
        return sb.toString();
    }

    //使用快速排序
    public static String largestNumber2(int[] nums){
        quickSort(nums,0,nums.length-1);

        if (nums[0] == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end){
            return;
        }
        int pivot = nums[start];
        int index = start;
        for (int i = start+1; i <= end; i++) {
            long x = 10, y = 10;
            while (x <= nums[i]){
                x *=10;
            }
            while (y <= pivot){
                y *=10;
            }
            if (nums[i] * y + pivot > pivot * x + nums[i]){
                index += 1;
                swap(nums,index,i);
            }
        }
        swap(nums, index, start);
        quickSort(nums,start,index-1);
        quickSort(nums,index+1,end);
    }
    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
