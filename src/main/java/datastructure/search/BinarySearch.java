package datastructure.search;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/1/18 15:25
 * @Description: *
 * * 注意：
 * * 二分查找只能查找有序数组
 */
public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        ArrayList<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(integers);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right) {
            return -1;
        }

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    //有重复数字的算法
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right) {
            return new ArrayList<Integer>();
        }
        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            //找到了后先别先别别着急返回，往左边和右边都找找
            int temp = mid - 1;
            while (true) {
                //注意 该数组是有序数组，所以有一个不是该数就可以退出了
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                //注意 该数组是有序数组，所以有一个不是该数就可以退出了
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }

            return list;
        }

    }

}
