package newcoder;


/**
 * @Author lxjj
 * @Date 2021-07-12 14:44
 * @Description 在旋转过的有序数组中寻找目标值
 */
public class NC48 {
    //二分查找
    public int search(int[] nums, int target) {
        // write code here
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]) { //前面有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            } else { //后半段有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = left + 1;
                } else {
                    right = right - 1;
                }
            }

        }
        return -1;
    }
}
