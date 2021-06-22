package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:lx
 * @Date: 2021/3/4 21:52
 * @Description: 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class LC4 {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ints = new int[m + n];
        for (int i = 0; i < n; i++) {
            ints[i] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            ints[n + i] = nums2[i];
        }
        Arrays.sort(ints);
        if ((m+n) %2 == 0){
            double mid1 = ints[(m+n)/2];
            double mid2 = ints[(m+n)/2 -1];
            double ans = (mid1+mid2)/2;
            return ans;
        }else{
            int mid = (m+n)/2;
            return ints[mid];
        }
    }
}
