package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/7 11:51
 * @Description:
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        //整三个表 数组，用来分别存储是否在行 列 3*3单元格内出现
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int curNum = board[i][j]-'0';
                if (row[i][curNum] != 0) return false;
                if (col[j][curNum] != 0) return false;
                if (box[(i/3)*3+j/3][curNum] != 0) return false;

                row[i][curNum] = 1;
                col[j][curNum] = 1;
                box[(i/3)*3+j/3][curNum] = 1;
            }
        }
        return true;
    }
}
