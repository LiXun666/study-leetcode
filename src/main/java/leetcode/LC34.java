package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/7 14:36
 * @Description:
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class LC34 {
    //O(n),一次遍历
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                res[0] = i;
                while (i+1 < nums.length && nums[i+1] == nums[i]){
                    i++;
                }
                res[1] = i;
                return res;
            }
        }
        return res;
    }

    //O(log n)的算法，使用二分查找
    public int[] searchRange2(int[] nums, int target){
        //找严格小于target的坐标
        int leftIdx = search(nums,target,true);
        int rightIdx = search(nums,target,false)-1;
        if (leftIdx <= rightIdx && rightIdx <nums.length && nums[leftIdx] == target && nums[rightIdx] == target){
            return new int[]{leftIdx,rightIdx};
        }
        return new int[]{-1,-1};

    }
    public int search(int[] nums, int target, boolean lower){
        int left = 0, right = nums.length - 1, res = nums.length;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid-1;
                res = mid;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

}
