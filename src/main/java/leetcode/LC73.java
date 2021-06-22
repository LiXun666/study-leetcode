package leetcode;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author:lx
 * @Date: 2021/3/22 11:19
 * @Description:
 */
public class LC73 {

    //先把为0的ij记录下来，再遍历一遍 让其归0；时间O（m*n）,空间O（m+n）
    public void setZeroes(int[][] matrix) {
        //按行遍历，如果找到该行为零的坐标
        Stack<Integer> row = new Stack<>();
        Stack<Integer> col = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        while (!row.isEmpty()) {
            Integer row2zero = row.pop();
            Arrays.fill(matrix[row2zero], 0);
        }
        while (!col.isEmpty()) {
            Integer col2zero = col.pop();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col2zero] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        //让第一行 第一列 记录
        //先记录下第一行第一列是否包含0
        boolean row0 = false;
        boolean col0 = false;
        for (int i = 0; i <matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                row0 = true;
                break;
            }
        }
        for (int i = 0; i <matrix.length; i++) {
            if (matrix[i][0] == 0){
                col0 = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i<matrix[0].length; i++){
            if (matrix[0][i] == 0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i< matrix.length; i++){
            if (matrix[i][0] == 0){
                Arrays.fill(matrix[i],0);
            }
        }
        if (col0){
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
        if (row0){
            Arrays.fill(matrix[0],0);
        }
    }
    //只用第一列作为记录空间O(1)
    public void setZeroes2(int[][] matrix){
        boolean col0 = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                col0 = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length-1; i >= 0 ; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
            if (col0){
                matrix[i][0] = 0;
            }
        }
    }
}
