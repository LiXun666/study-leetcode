package leetcode;


import javafx.scene.transform.Rotate;

import java.util.Arrays;

/**
 * @Author:lx
 * 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @Date: 2021/1/8 9:41
 * @Description:
 */
public class LC189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = Arrays.copyOfRange(nums, 0, n-k);

        System.arraycopy(nums, n-k, nums, 0, k);

        System.arraycopy(temp, 0, nums, k, n-k);


    }
}
