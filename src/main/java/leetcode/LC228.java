package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:lx
 * 汇总区间
 *
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @Date: 2021/1/10 16:34
 * @Description:
 */
public class LC228 {
    public static void main(String[] args) {
        int[] nums = {0,2,3,5,7};
        List<String> list = summaryRanges(nums);
        for (String lists : list) {
            System.out.println(list);
        }
    }
    public static List<String> summaryRanges(int[] nums) {

        ArrayList<String> list = new ArrayList<>();

        int slow = 0;
        int fast = 0;
        int n = nums.length;
        if (n == 1){
            list.add(nums[0] + "");
            return list;
        }

        for (int i = 0; i<n-1;i++){
            if (nums[i+1] - nums[i] == 1){
                fast++;
            }else{
                if (slow == fast){
                    list.add(nums[fast]+"");
                }else {
                    list.add(nums[slow]+"->"+nums[fast]);
                }
                slow = fast+1;
                fast = slow;
            }
            if (fast == n-1){
                if (slow == fast){
                    list.add(nums[fast]+"");
                }else {
                    list.add(nums[slow]+"->"+nums[fast]);
                }
            }
        }
        return list;
    }
}
