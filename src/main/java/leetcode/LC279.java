package leetcode;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-06-11 9:41
 * @Description
 * 完全平方数
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 */
public class LC279 {
    //动态规划
    public int numSquares(int n) {
        //dp[i]，i需要最小数量的完全平方和
        int[] dp = new int[n+1];
        //由dp[0] = 0转移过来
        for (int i = 1; i <= n; i++) {
            int min = Integer.MIN_VALUE;
            //枚举j,知道1-根号i之间最小的数量，该数量+1即为dp[i]
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min,dp[i - j*j]);
            }
            dp[i] = 1+ min;
        }
        return dp[n];
    }

    /*
    bfs,层级访问，每一层相当于一个数量
    1.把该数放入，找到若干小于他的 减去某个完全平方数作为下一层，
    2.继续该操作，visited作为判断是否访问过该书，如果访问过相当与添加过，没必要在访问一次
    3.如果某次减去某个平方数等于0，相当于找个了该层数level
     */
    public int numSquares2(int n){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int cur = queue.poll();

                for (int j = 1; j * j <= cur; j++){
                    //查看 cur - j*j
                    int temp= cur- j*j;
                    if (temp == 0){
                        return level;
                    }
                    if (!visited.contains(temp)){
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
        }
        return -1;
    }
}
