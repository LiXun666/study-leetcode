package datastructure.sort;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/1/14 17:58
 * @Description:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3};
        int left = 0;
        int right = arr.length-1;
        int[] temp = new int[arr.length];

        mergeSort(arr,left,right,temp);
        System.out.println(Arrays.toString(arr));
    }

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
