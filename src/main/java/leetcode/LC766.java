package leetcode;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * @author: liuhj
 * @Date: 2021/2/22 10:22
 * Description:
 */
public class LC766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i< matrix.length; i++){
            for (int j = 1; j <matrix[0].length; j++){
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
