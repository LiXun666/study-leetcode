package leetcode;

import java.util.Arrays;

/**
 * @Author lxjj
 * @Date 2021-07-15 11:27
 * @Description 减小和重新排列数组后的最大元素
 */
public class LC1846 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1; i< arr.length; i++){
            arr[i] = Math.min(arr[i], arr[i-1]+1);
        }
        return arr[arr.length-1];
    }
}
