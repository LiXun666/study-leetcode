package leetcode;

import java.awt.font.NumericShaper;

/**
 * @Author:lx
 * @Date: 2021/3/16 22:20
 * @Description:
 * 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 */
public class LC167 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int sum = target - numbers[i];
            int left = i +1, right  = n -1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if (numbers[mid] == sum){
                    return new int[]{i+1,mid+1};
                }else if (numbers[mid] < sum){
                    left = mid +1;
                }else{
                    right = mid- 1;
                }
            }
        }
        return new int[]{-1,-1};
    }
    //双指针
    public int[] twoSum2(int[] numbers, int target){
        int n = numbers.length;
        int left = 0,right = n-1;
        while (left < right){
            if (numbers[left] + numbers[right] ==  target){
                return new int[]{left+1,right+1};
            }else if ((numbers[left] + numbers[right] >  target)){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
