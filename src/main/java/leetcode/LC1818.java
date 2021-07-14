package leetcode;

import java.util.Arrays;

/**
 * @Author lxjj
 * @Date 2021-07-14 9:35
 * @Description 绝对差值和
 */
public class LC1818 {
    public static void main(String[] args) {
        int[] nums1 = {1,28,21};
        int[] nums2 = {9, 21, 20};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    //max{|nums1[i]-nums2[i]| - |nums1[j]-nums2[i]|}找到最大的该值；
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        //找插值最大的i、
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        for (int i = 0; i < n; i++) {
            rec[i] = nums1[i];
        }
        Arrays.sort(rec);

        int sum = 0;
        int maxn = 0;
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum = (sum+abs)%MOD;

            //rec[j]与nums2[i]最接近,
            // 找的是第一个大于nums[i]的，最接近可能是j的前一个也有可能是j，所以要比较两次
            int j =  search(rec,nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, abs - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, abs - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum-maxn +MOD)%MOD;
    }

    //二分查找
    private static int search(int[] rec, int target) {
        int left = 0, right = rec.length-1;
        if (rec[right] < target) return right+1;
        while (left < right){
            int mid = left + (right -left)/2;
            if (rec[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
