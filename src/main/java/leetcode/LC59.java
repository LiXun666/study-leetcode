package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/16 10:29
 * @Description:
 * 螺旋矩阵 II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class LC59 {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    //时间复杂度O(n*n),空间复杂度O(1)即需要返回的数组
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0,bottom = n-1, left = 0, right = n-1;
        int index = 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                res[top][i] = index;
                index++;
            }
            for (int j = top+1; j <= bottom; j++){
                res[j][right] = index;
                index++;
            }
            if (left < right && top < bottom){
                for (int i = right - 1; i > left; i--){
                    res[bottom][i] = index++;
                }
                for (int j = bottom; j > top; j--){
                    res[j][left] = index++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
