package leetcode;

/**
 * @Author lxjj
 * @Date 2021-06-08 10:12
 * @Description 最后一块石头的重量 II
 * 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 */
public class LC1049 {

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII3(stones));
    }

    //1维
    public static int lastStoneWeightII(int[] stones) {
        //计算sum
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        //最大容量为cap = sum/2
        int cap = sum / 2;
        int[] dp = new int[cap + 1];
        for (int stone : stones) {
            //j表示最大
            for (int j = cap; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return sum - dp[cap] * 2;
    }

    //2维
    public static int lastStoneWeightII2(int[] stones) {
        //dp[i][j],表示前i个背包，能放入j最大容量背包的实际大小
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        //最大容量
        int cap = sum / 2;
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= cap; j++) {
                //当可以放进去时
                if (j >= stones[i - 1]) {
                    //可以选择放入或不放入，取两个的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    //放不起进去
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - dp[n][cap] * 2;
    }

    //1维
    public static int lastStoneWeightII3(int[] stones) {
        //根据推导，当石头最小可能重量时，最好子集数组石头的总重量，趋近于 且 最大为 sum / 2
        //构建dp数组，dp[i] 表示，是否有子集数组，重量和为i
        //遍历 stones数组，生成dp数组的值
        //从 最大值 开始，遍历dp数组，寻找最大i的值，得出结果
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        //最大容量
        int cap = sum / 2;
        boolean[] dp = new boolean[cap + 1];
        //边界条件,肯定有重量为0
        dp[0] = true;
        for (int stone : stones) {
            for (int i = cap; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        for (int i = cap; ; i--) {
            if (dp[i]) {
                return sum - i *2;
            }
        }
    }
}
