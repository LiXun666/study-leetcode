package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author lxjj
 * @Date 2021-07-01 9:55
 * @Description 传递信息
 */
public class LCP7 {
    public int numWays(int n, int[][] relation, int k) {
        //dp【i】【j】,经过i伦，可以到达j
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] ints : relation) {
                //该轮到达了dis时，下一轮就可以到达j，通过这个进行更新
                int src = ints[0], dst = ints[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    //dfs,找路径，找到了就+1
    int ways, n, k;
    List<List<Integer>> edges;

    public int numWays2(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        edges = new ArrayList<>();
        for (int i = 0; i<n;i++){
            edges.add(new ArrayList<>());
        }
        for (int[] ints : relation) {
            int src = ints[0], dst = ints[1];
            edges.get(src).add(dst);
        }
        dfs(0,0);

        return ways;
    }

    private void dfs(int index, int steps) {
        if (steps == k){
            if (index == n-1){
                ways++;
            }
            return;
        }
        List<Integer> src = edges.get(index);
        for (Integer nextIndex : src) {
            dfs(nextIndex, steps+1);
        }
    }


    //bfs，把每层到达的结果都写进去，最后数个数
    public int numWays3(int n, int[][] relation, int k){
        edges = new ArrayList<>();
        for (int i = 0; i<n;i++){
            edges.add(new ArrayList<>());
        }
        for (int[] ints : relation) {
            int src = ints[0], dst = ints[1];
            edges.get(src).add(dst);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int steps = 0;
        while (!queue.isEmpty() && steps<k){
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                List<Integer> list = edges.get(poll);
                for (Integer integer : list) {
                    queue.offer(integer);
                }
            }
        }
        int ways = 0;
        for (Integer integer : queue) {
            if (integer == n-1) ways++;
        }
        return ways;
    }
}
