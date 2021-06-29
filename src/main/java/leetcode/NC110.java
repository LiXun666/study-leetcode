package leetcode;

/**
 * @Author lxjj
 * @Date 2021-06-29 11:09
 * @Description 旋转数组
 * 一个数组A中存有N（N&gt0）个整数，
 * 在不允许使用另外数组的前提下，将每个整数循环向右移M（M>=0）个位置，
 * 即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）
 */
public class NC110 {
    public int[] solve(int n, int m, int[] a) {
        // write code here
        int times = m % n;
        if (times == 0) return a;
        //右移
        boolean flag = true;
        if (times > n / 2) {
            times = n - times;
            flag = false;
        }
        while (times > 0) {
            if (flag) {
                int temp = a[n - 1];
                for (int i = n - 1; i >= 0; i--) {
                    if (i == 0) {
                        a[i] = temp;
                        break;
                    }
                    a[i] = a[i - 1];
                }
            } else {
                int temp = a[0];
                for (int i = 0; i < n; i++) {
                    if (i == n - 1) {
                        a[i] = temp;
                        break;
                    }
                    a[i] = a[i + 1];
                }
            }
            times--;
        }
        return a;
    }
}