package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/14 13:23
 * @Description: 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class LC48 {

    //旋转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j];
                matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    //翻转
    public void rotate2(int[][] matrix){
        //先水平翻转，然后对角线翻转
        int n = matrix.length;
        for (int i = 0; i < n/2 ; i++){
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        //对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
