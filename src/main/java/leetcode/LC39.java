package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

/**
 * @Author:lx
 * @Date: 2021/4/7 12:23
 * @Description:
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 */
public class LC39 {

    //回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        process(res,ans,candidates,target,0);
        return res;
    }
    public void process(List<List<Integer>> res, List<Integer> ans, int[] candidates, int target, int index){
        if (index == candidates.length){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        process(res,ans,candidates,target,index+1);
        if (target - candidates[index] >=0){
            ans.add(candidates[index]);
            process(res,ans,candidates,target - candidates[index],index);
            ans.remove(ans.size()-1);
        }

    }
}
