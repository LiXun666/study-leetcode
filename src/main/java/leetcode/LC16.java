package leetcode;

import javax.swing.plaf.metal.MetalTheme;
import javax.xml.ws.soap.MTOM;
import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/3/22 14:18
 * @Description: 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class LC16 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        System.out.println(threeSumClosest(nums, 1));
    }

    //排序+双指针
    //1，如果三个数之和为target，直接返回
    //2，如果target比三个数的最大值还要大，则直接用三个数的最大值进行判断，更新res,如果小同理
    //3，如果两个数相同，则无需寻找最小值，指针++， if (i > 0 && nums[i] == nums[i - 1]) continue;
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minAbs = Integer.MAX_VALUE;
        //每次找到三个数的和都与res比较更新最小的
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (target < (nums[left] + nums[left+1] + nums[i])){
                    if (minAbs > Math.abs(target - (nums[left+1] + nums[left] + nums[i]))){
                        minAbs = Math.abs(target - (nums[left+1] + nums[left] + nums[i]));
                        res=nums[left+1] + nums[left] + nums[i];
                    }
                    break;
                }
                if (target >(nums[right] + nums[right-1] + nums[i])){
                    if (minAbs > Math.abs(target - (nums[right] + nums[right-1] + nums[i]))){
                        minAbs = Math.abs(target - (nums[right] + nums[right-1] + nums[i]));
                        res=nums[right] + nums[right-1] + nums[i];
                    }
                    break;
                }
                if (nums[right] + nums[left] + nums[i] == target){
                    return target;
                }
                if (Math.abs(target - (nums[right] + nums[left] + nums[i])) < minAbs) {
                    minAbs = Math.abs(target - (nums[right] + nums[left] + nums[i]));
                    res = nums[left] + nums[right] + nums[i];
                }
                if ((nums[right] + nums[left] + nums[i]) < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
