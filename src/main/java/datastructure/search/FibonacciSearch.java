package datastructure.search;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/1/20 11:35
 * @Description: 黄金分割法
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr,1234));
    }

    //
    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * @param a   数组
     * @param key 查找的值
     * @return 返回对应下标
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0; //表示斐波那契数列的下标
        int mid = 0; //表示构造的中值的位置
        int f[] = fib();//获取斐波那契数列
        //获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需求使用a数组的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            }else{
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;

    }
}
