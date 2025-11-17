class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount=0;
        int r=grid.length, c=grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    int area = dfs(grid, i, j);
                    maxCount = Math.max(maxCount, area);
                }
            }
        }
        return maxCount;
    }
    public int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
    }
}