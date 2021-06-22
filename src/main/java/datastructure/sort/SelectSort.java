package datastructure.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/1/12 22:07
 * @Description:
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,99,112,56,72};

        selectSort(arr);
    }

    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++){
            //首先让最小指向循环开始的索引
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++){
                //找到后面数组中最小的索引
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            //让最小的与开始的索引交换，如果开始的索引就是最小的则不需要交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
