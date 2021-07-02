package leetcode;

import java.util.Arrays;

/**
 * @Author lxjj
 * @Date 2021-07-02 9:49
 * @Description 雪糕的最大数量
 */
public class LC1833 {

    //排序+贪心(买最便宜的)
    public int maxIceCream(int[] costs, int coins) {
        //肯定买最便宜的的雪糕
        int count = 0;
        Arrays.sort(costs);
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            if (sum + costs[i] > coins) return count;
            sum += costs[i];
            count++;
        }
        return count;
    }

    //计数排序
    public int maxIceCream2(int[] costs, int coins) {
        int[] fre = new int[100001];
        for (int cost : costs) {
            fre[cost]++;
        }
        int count = 0;
        for (int i = 1; i < 100001; i++) {
            if (fre[i] == 0) continue;
            if (coins < i) return count;

            int curCount = Math.min(fre[i], coins / i);
            count += curCount;
            coins -= i * curCount;

        }
        return count;
    }
}
