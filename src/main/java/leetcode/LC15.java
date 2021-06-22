package leetcode;

import javax.annotation.Resource;
import java.awt.font.NumericShaper;
import java.util.*;

/**
 * @Author:lx
 * @Date: 2021/3/16 18:56
 * @Description:
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 */
public class LC15 {
    public static void main(String[] args) {
        int[] nums= {-1,0,0,1,-1,-4,1,2,1};
        List<List<Integer>> lists = threeSum3(nums);
        System.out.println(lists.toString());
    }

    //超出时间限制
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    //排序+双指针
    public static List<List<Integer>> threeSum2(int[] nums){
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums); // O(nlogn)
        Set<List<Integer>> res = new HashSet<>();

        //确定第一个数后，找到后面数等于-num的数
        //O(n^2)
        for (int i = 0; i <nums.length; i++){
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }else if (nums[left] + nums[right] > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return new ArrayList<>(res); //O(n) 把这个优化掉
    }


    //去重优化
    public static List<List<Integer>> threeSum3(int[] nums){
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums); // O(nlogn)
        List<List<Integer>> res = new ArrayList<>();

        //确定第一个数后，找到后面数等于-num的数
        //O(n^2)
        for (int i = 0; i <nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }else if (nums[left] + nums[right] > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res; //O(n) 把这个优化掉
    }
}
