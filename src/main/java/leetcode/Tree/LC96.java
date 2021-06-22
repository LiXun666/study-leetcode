package leetcode.Tree;

/**
 * @Author:lx
 * @Date: 2021/5/13 10:40
 * @Description:
 * 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class LC96 {

    //超时
    public int numTrees(int n) {
        return count(1,n);
    }

    private int count(int low, int high) {
        if (low > high){
            return 1;
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low,i-1);
            int right = count(i+1,high);
            res += left*right;
        }
        return res;
    }

    //动态规划优化
    int[][] dp;
    public int numTrees2(int n) {
        //dp[low][high]
        dp = new int[n+1][n+1];
        return count2(1,n);
    }

    private int count2(int low, int high){
        //使用过就把dp更新，后面遇到直接调用
        if (low > high) return 1;
        int res = 0;
        if (dp[low][high] != 0) return dp[low][high];
        for (int i = low; i <= high; i++) {
            int left = count2(low,i-1);
            int right = count2(i+1,high);
            res += left * right;
        }
        dp[low][high] = res;
        return res;
    }

}
