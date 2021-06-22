package leetcode;

import java.util.*;

/**
 * @Author:lx
 * @Date: 2021/4/13 15:36
 * @Description:
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class LC46 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permute(nums);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<Integer>();;
        int len = nums.length;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        dfs(res,path,0,len,used,nums);
        return res;
    }

    private  static void dfs(List<List<Integer>> res, Deque<Integer> path, int depth, int len, boolean[] used, int[] nums) {
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++){
            if(used[i] || (i>0 && nums[i] == nums[i-1]) && used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(res,path,depth+1,len,used,nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
