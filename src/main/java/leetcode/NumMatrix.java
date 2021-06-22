package leetcode;

import javax.lang.model.type.ErrorType;

/**
 * @Author:lx
 * @Date: 2021/3/2 16:02
 * @Description: 二维区域和检索 - 矩阵不可变
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * [[[[3,0,1,4,2],
 * [5,6,3,2,1],
 * [1,2,0,1,5],
 * [4,1,0,1,7],
 * [1,0,3,0,5]]],
 * <p>
 * <p>
 * [2,1,4,3],[1,1,2,2],[1,2,2,4]]
 */
public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - (sums[row1][col2 + 1] + sums[row2 + 1][col1] - sums[row1][col1]);
    }
}
