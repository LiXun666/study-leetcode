package leetcode;

import java.lang.annotation.ElementType;
import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/4/6 13:49
 * @Description:
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class LC215 {
    //排序,调用系统方法
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }

    //排序，快速排序
    public int findKthLargest1(int[] nums, int k){
        int[] temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
        return nums[nums.length -k];
    }
    private void quickSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int left = l,right = r;
        int pivot = nums[left];
        while (left < right){
            while(left < right && nums[right] >= pivot){
                right--;
            }
            if (left < right){
                nums[left] = nums[right];
            }
            while(left < right && nums[left] <= pivot){
                left++;
            }
            if (left < right){
                nums[right] = nums[left];
            }
            if (left >= right){
                nums[left] = pivot;
            }
        }
        quickSort(nums,l,right-1);
        quickSort(nums,right+1,r);
    }

    //排序，归并排序
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            //给左边分
            mergeSort(arr,left,mid,temp);
            //给右边分
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        //左边第一个指针
        int i = left;
        //右边第一个指针
        int j = mid +1;
        //新数组第一个指针
        int t = 0;
        //让左边和右边的第一个指针比较
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }

        //下来需要吧temp的赋值给arr
        t = 0;
        //定义一个arr的左指针
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }

}
