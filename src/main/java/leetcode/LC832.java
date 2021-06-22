package leetcode;

import java.util.Arrays;

/**
 * @author: liuhj
 * @Date: 2021/2/24 9:59
 * Description:
 */
public class LC832 {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(A);
    }

    /*
    直接法：
    1.把A每一行翻转拷贝到新数组
    2.遍历新数组，1变0 0变1
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = A[i][n - j - 1];
            }
            System.out.println(Arrays.toString(ans[i]));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = 0;
                }

            }
        }
        return ans;
    }

    /*
    用left和right两个指针，left+right = n+1;
    情况：
    两个值相等，则两个值取反
    两个值不等,不需要变化
     */
    public static int[][] flipAndInvertImage2(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++){
            int left = 0,right = n-1;
            while (left < right){
                if (A[i][left] == A[i][right]){
                    //如果该数与1相等 则等于0，否则等于1
                    //即 0 ^= 1 =1, 1 ^= 1= 0,达到的取反的效果
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            //如果最后相等了,该位翻转
            if (left == right){
                A[i][left] ^= 1;
            }
        }
        return A;
    }

}
