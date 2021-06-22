package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/1 9:43
 * @Description:
 * LC303
 * 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 实现 NumArray 类：
 */
public class NumArray {
    int sum[];
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        for (int i = 0;i<n;i++){
            sum[i+1] = sum[i] + nums[i+1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}
