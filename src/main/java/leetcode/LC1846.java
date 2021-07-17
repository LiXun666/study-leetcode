package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-15 11:27
 * @Description 减小和重新排列数组后的最大元素
 */
public class LC1846 {
    public static void main(String[] args) {


        int[] arr = new int[]{2, 2, 3};
        System.out.println(maximumElementAfterDecrementingAndRearranging2(arr));
    }
    //排序+贪心
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1; i< arr.length; i++){
            arr[i] = Math.min(arr[i], arr[i-1]+1);
        }
        return arr[arr.length-1];
    }
    public static int maximumElementAfterDecrementingAndRearranging2(int[] arr){
        int n = arr.length;
        int[] cnt = new int[n+1];
        for (int a : arr){
            cnt[a]++;
        }
        int zeroCnt = 0;
        for (int i = 1; i < n+1; i++) {
            if (cnt[i] == 0){
                zeroCnt++;
            }
        }
        return n -zeroCnt;
    }
}
