package hj;

import com.sun.javafx.scene.traversal.Direction;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-28 11:11
 * @Description
 */
public class HJ43 {
    //结果集
    private static List<int[]> res;
    //定义一下方向
    private static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    //定义是否被访问
    private static boolean[][] visited;
    //定义一个路径栈
    private static Stack<int[]> path;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] puzzle = new int[m][n];
            for(int i = 0; i<m;i++){
                for(int j = 0; j<n;j++){
                    puzzle[i][j] = sc.nextInt();
                }
            }
            visited = new boolean[m][n];
            path = new Stack<>();
            backTrace(puzzle,0,0);
            for (int[] re : res) {
                System.out.println("("+re[0]+","+re[1]+")");
            }
            res = null;
        }
    }

    //回溯
    private static void backTrace(int[][] puzzle, int i, int j) {
        //判断什么情况下返回
        //1.边界的情况下2。被访问的情况下3。等于1的情况下
        if (i>=puzzle.length || i<0 || j>=puzzle[0].length || j<0 || visited[i][j] || puzzle[i][j] ==1 || res !=null) return;
        //就该结束了
        if (i == puzzle.length-1 && j == puzzle[0].length-1){
            path.add(new int[]{i,j});
            res = new ArrayList<>(path);
            return;
        }
        path.add(new int[]{i,j});
        visited[i][j] = true;
        for (int k = 0; k<4;k++){
            backTrace(puzzle,i+direction[k][0],j+direction[k][1]);
        }
        visited[i][j] = false;
        path.pop();
    }
}
