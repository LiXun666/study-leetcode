package datastructure.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author:lx
 * @Date: 2021/1/14 14:36
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,3,2};

        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        //定义左右指针
        int l = left;
        int r = right;
        //定义中间的数
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            //找到左边大于中间的数
            while (arr[l] < pivot) {
                l++;
            }
            //找到右边的小于中间的数
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //当上面两个循环出来的时候，应该得到两个指针l和r，这两个需要互换
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            //左边的数与中间的数交换换了，需要把r--,否则会一直交换
            if (arr[l] == pivot) {
                r--;
            }
            //同理，右边也需要这样
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }

        //左边递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //右边递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void quickSort2(int[] arr, int start, int end) {
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
            quickSort2(arr, start, low-1);
            quickSort2(arr, low + 1, end);
        }
    }

    //左神 方法 随机快速排序
    public static void quickSort3(int[] arr, int left, int right) {
        if (left < right) {
            //随机选择一个数做划分,随机快排
            swap(arr, left + (int) Math.random() * (right - left + 1), right);
            int[] p = partition(arr, left, right);
            quickSort3(arr, left, p[0] - 1);
            quickSort3(arr, p[1] + 1, right);
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }


    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    //快速排序
    public static void quickSort4(int[] arr, int left, int right){
        if (left < right){
            int pivot = arr[left];
            int index = left;
            for (int i = left+1; i <= right; i++) {
                if (arr[i] < pivot){
                    index++;
                    swap(arr,i,index);
                }
            }
            swap(arr,index,left);
            quickSort4(arr,left,index-1);
            quickSort4(arr,index+1,right);
        }
    }
}
