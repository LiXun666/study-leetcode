package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/3/15 10:25
 * @Description:
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class LC54 {

    //层级遍历，每次遍历完整体缩小一圈
    //终止条件就是不能在缩小了
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length -1;
        int top  = 0;
        int bottom = matrix.length - 1;

        if (matrix ==null || right < 0 || bottom < 0){
            return res;
        }

        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            for (int j = top+1; j <= bottom; j++){
                res.add(matrix[j][right]);
            }
            if (left < right && top < bottom){
                for (int i = right-1; i > left; i--){
                    res.add(matrix[bottom][i]);
                }
                for (int j = bottom; j > top; j--){
                    res.add(matrix[j][left]);
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
