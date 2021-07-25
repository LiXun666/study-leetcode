package leetcode;

/**
 * @Author lxjj
 * @Date 2021-07-25 19:42
 * @Description
 * 跳跃游戏
 */
public class LC55 {
    public boolean canJump(int[] nums){
        int max = 0;
        for(int i = 0; i<nums.length;i++){
            if (i <= max){
                max=Math.max(max,nums[i]+i);
                if (max >= nums.length-1) return true;
            }
        }
        return false;
    }
}
