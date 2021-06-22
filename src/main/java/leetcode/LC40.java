package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/4/7 22:13
 * @Description:
 * 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 */
public class LC40 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(candidates,target);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> ans = new ArrayList();
        Arrays.sort(candidates);
        process(res,ans,candidates,target,0);
        return res;
    }
    public static void process(List<List<Integer>> res, List<Integer> ans,int[] candidates, int target, int index){
        if(target == 0){
            res.add(new ArrayList(ans));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            ans.add(candidates[i]);
            process(res,ans,candidates,target-candidates[i],i+1);
            ans.remove(ans.size()-1);

        }

    }
}
