package newcoder;

/**
 * @Author lxjj
 * @Date 2021-07-14 14:45
 * @Description 三个数的最大乘积
 */
public class NC106 {
    public long solve(int[] A) {
        // write code here
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : A) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > first) {
                third = second;
                second = first;

                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }
        return Math.max((long)first*second*third,(long)first*min1*min2);
    }
}
