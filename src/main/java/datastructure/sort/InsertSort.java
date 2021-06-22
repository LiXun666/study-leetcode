package datastructure.sort;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/1/13 14:21
 * @Description:
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] arr = new int[8000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000);
        }

        System.out.println(Arrays.toString(arr));
        insertSort(arr);
    }
    public static void  insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            //定义每次也好插入的值和索引
            int insertVal = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //找到该插入的位置，该位置为insertIndex+1，因为如果不满足退出while循环,则需要插入的位置在insertIndex的后面
            arr[insertIndex+1] = insertVal;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort2(int[] arr){
        if (arr == null || arr.length < 2 ){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j++){
                swap(arr, j, j+1);
            }
        }
    }
    public static void swap(int[] nums,int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
