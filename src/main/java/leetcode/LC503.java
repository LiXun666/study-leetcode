package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/7 19:16
 * @Description: 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 */
public class LC503 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        nextGreaterElements(nums);

    }

    //暴力解法,时间复杂度o(N^2),
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + i; j++) {
                if (nums[j % n] > nums[i]) {
                    res[i] = nums[j % n];
                    break;
                }
                res[i] = -1;
            }
        }
        return res;
    }

    //单调栈时间复杂度为 O(n)
    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res,-1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
