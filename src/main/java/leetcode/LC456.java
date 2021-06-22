package leetcode;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/25 16:09
 * @Description:
 * 132 模式
 *
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 */
public class LC456 {
    public static void main(String[] args) {
        int[] nums = {3,5,0,3,4};
        System.out.println(find132pattern1(nums));
    }

    //超出时间限制
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return false;
        }
        for (int i = n-1; i >= 2; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    for (int k = j; k <i; k++) {
                        if (nums[k] > nums[i]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean find132pattern1(int[] nums){
        int n = nums.length;
        if (n < 3){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        //让numsk一直为第二大的数
        int numsk = Integer.MIN_VALUE;

        for (int i = n-1; i >= 0; i--){
            if (stack.isEmpty()){
                stack.push(nums[i]);
            }else {
                if (nums[i] > stack.peek()){
                    while (!stack.isEmpty() && nums[i] > stack.peek()){
                        numsk = stack.pop();
                    }
                    stack.push(nums[i]);
                }else {
                    stack.push(nums[i]);
                    if (nums[i] < numsk){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
