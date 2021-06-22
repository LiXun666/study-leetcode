package leetcode;

import java.util.*;

/**
 * @Author:lx
 * @Date: 2021/4/13 16:29
 * @Description:
 * 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<Integer>();;
        int len = nums.length;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        dfs(res,path,0,len,used,nums);
        return new ArrayList<>(res);
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> stack, int depth, int len, boolean[] used, int[] nums) {
        if(depth == len){
            res.add(new ArrayList<>(stack));
        }
        for(int i = 0; i<len ; i++){
           if (used[i] || (i>0 && used[i-1] && nums[i] == nums[i-1])){
               continue;
           }
           stack.addLast(nums[i]);
           used[i] = true;
           dfs(res,stack,depth+1,len,used,nums);
           stack.removeLast();
           used[i] = false;
        }
    }
}
