package leetcode;

/**
 * @Author:lx
 * 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 * @Date: 2020/10/26 14:04
 * @Description:
 */
public class LC1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] a = new int[nums.length];
        for (int i = 0; i< nums.length; i++){
        int sum = 0;
        for (int j = 0; j<nums.length; j++){

            if (nums[j] < nums[i]){
                sum++;
            }

        }
        a[i] = sum;
    }
        return a;
}
}
