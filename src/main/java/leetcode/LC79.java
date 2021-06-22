package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/6 20:06
 * @Description: 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class LC79 {
    private static final int[][] DERECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    //board的长宽
    private int rows;
    private int cols;

    //word对应的数组
    private char[] charArray;
    //word的长度
    private int len;
    private boolean[][] visited;
    private char[][] board;


    //回溯+dfs
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        visited = new boolean[rows][cols];

        charArray = word.toCharArray();
        len = word.length();
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]){
            visited[x][y] = true;
            for(int[] direction : DERECTIONS){
                int newX = x+direction[0];
                int newY = y+direction[1];
                if (isArea(newX,newY) && !visited[newX][newY]){
                    if(dfs(newX,newY,begin+1)){
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean isArea(int x, int y) {
        return x>=0 && x<=rows && y>=0 && y<=cols;
    }

}
