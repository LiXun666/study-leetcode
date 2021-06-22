package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/3 9:45
 * @Description: 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class LC338 {

    //直接计算，使用位与运算计算 1的数量，计算一次少一个1
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    public int count(int i) {
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }

    //动态规划+位运算
    public int[] countBits2(int num) {
        int[] ints = new int[num + 1];
        int high = 0;
        for (int i = 1; i < num + 1; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            ints[i] = ints[i - high] + 1;
        }
        return ints;
    }

}
