package datastructure.search;

import sun.security.util.Length;

/**
 * @Author:lx
 * @Date: 2021/1/19 12:11
 * @Description:
 * 插值查找尽量找数据比较连续跨度不大的数组
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        int i = insertValueSearch(arr, 0, arr.length - 1, 50);
        System.out.println(i);


    }

    public static int insertValueSearch(int[] arr, int left, int right, int findValue){
        if (left > right || findValue < arr[0] || findValue > arr[arr.length-1]){
            return -1;
        }

        //使用差值公式定义mid
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue < midValue){
            return insertValueSearch(arr,left,mid-1,findValue);
        }else if (findValue > midValue){
            return insertValueSearch(arr,mid+1,right,findValue);
        }else {
            return mid;
        }

    }
}
