package leetcode;

/**
 * @Author lxjj
 * @Date 2021-06-22 17:35
 * @Description 整数的各位积和之差
 */
public class LC1281 {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n != 0) {
            int temp = n % 10;
            sum += temp;
            product *= temp;

            n /= 10;
        }
        return product - sum;

    }
}
