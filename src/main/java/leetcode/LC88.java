package leetcode;

import datastructure.sort.QuickSort;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/4/15 16:02
 * @Description:
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素
 */
public class LC88 {
    //系统方法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        quickSort(nums1,0,m-1);
    }
    //拷贝+快排数
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        quickSort(nums1,0,m-1);
////        Arrays.sort(nums1);
    }
    //双指针发
    public void merge3(int[] nums1, int m, int[] nums2, int n){
        int idxm = m-1, idxn = n-1;
        while(idxm >=0 && idxn >=0){
            if (nums1[idxm]>=nums2[idxn]){
                nums1[idxm+idxn+1] = nums1[idxm];
                idxm--;
            }else{
                nums1[idxm+idxn+1] = nums2[idxn];
                idxn--;
            }
        }
        while(idxn >= 0){
            nums1[idxn] = nums2[idxn];
            idxn--;
        }
    }


    //paixu
    public static void quickSort(int[] arr, int start, int end) {
        //终止条件，如果start等于end相当于只有一个数，那么就不用再排了
        if (start < end) {
            //吧第一个数字当做标准数
            int stard = arr[start];
            //定义两个指针
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && stard < arr[high]) {
                    high--;
                }
                if (low<high){
                    arr[low++] = arr[high];
                }
                while (low < high && arr[low] < stard) {
                    low++;
                }
                if (low<high){
                    arr[high--] = arr[low];
                }

            }
            arr[low] = stard;
            quickSort(arr, start, low-1);
            quickSort(arr, low + 1, end);
        }
    }
    public static void quickSort2(int[] arr, int start, int end){
        if (start < end){
            int target = arr[start];
            int index = start;
            for (int i = start+1; i <=end; i++) {
                if (arr[i] < target){
                    index++;
                    swap(arr,i,index);
                }
            }
            swap(arr,index,start);
            quickSort2(arr,start,index-1);
            quickSort2(arr,index+1,end);
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

}
