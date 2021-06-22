package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:lx
 * @Date: 2021/3/5 10:55
 * @Description: 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 思路:
 * 1.按照w指标升序，按照h指标降序
 * 2.计算h中的最长子序列
 */
public class LC354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        //按照w指标升序，按照h指标降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        int ans = 1;
        int[] count = new int[n];
        Arrays.fill(count,1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++){
                if (envelopes[j][1] < envelopes[i][1]){
                    count[i] = Math.max(count[i], count[j]+1);
                }
            }
            ans = Math.max(ans,count[i]);
        }
        return ans;
    }


    //第二步使用 二分查找+动态规划 LC300
    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        //按照w指标升序，按照h指标降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        //找到最长子序列 动态规划+二分查找
        int[] tails = new int[n];
        int res = 0;
        for (int x = 0; x<n; x++){
            int i = 0, j = res;
            while (i < j){
                int m = (i+j)/2;
                if (tails[m] < envelopes[x][1]) i = m+1;
                else j = m;
            }
            tails[i] = envelopes[x][1];
            if (res == j) res++;
        }
        return res;
    }
}
