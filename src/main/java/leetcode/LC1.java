package leetcode;

/**
 * @Author:lx
 * @Date: 2020/10/21 17:51
 * @Description:
 */
public class LC1 {
    public int[] twoSum(int[] nums, int target) {
       for (int i=0; i<nums.length-1;i++){
            for (int j = i+1; j<nums.length;j++){
                if (target == nums[i]+nums[j]){
                    return new int[]{i,j};
                }
            }
        }

       return null;
    }
}
