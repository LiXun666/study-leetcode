package leetcode;

/**
 * @Author lxjj
 * @Date 2021-08-11 18:25
 * @Description
 */
public class LC827 {
    static boolean[][] vis;

    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,0}};
        largestIsland(grid);
    }
    public static int largestIsland(int[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i = 0; i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    ans = Math.max(ans,dfs(grid,i,j));
                    grid[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static int dfs(int[][] grid,int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j]||grid[i][j]==0){
            return 0;
        }
        vis[i][j] = true;
        int a = dfs(grid,i+1,j);
        int b = dfs(grid,i-1,j);
        int c = dfs(grid,i,j+1);
        int d = dfs(grid,i,j-1);
        return 1+a+b+c+d;
    }
}
