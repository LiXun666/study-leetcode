package leetcode;

/**
 * @Author lxjj
 * @Date 2021-08-10 23:54
 * @Description
 */
public class LC200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(dfs(grid,i,j) >0){
                    ans++;
                }
            }
        }
        return ans;
    }
    public int dfs(char[][] grid,int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j] = '0';
        return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
    }
}
