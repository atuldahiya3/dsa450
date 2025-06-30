class Solution10 {
    public int numEnclaves(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<col;i++){
            if(grid[0][i]==1) dfs(grid,0,i);
            if(grid[row-1][i]==1) dfs(grid,row-1,i);
        }
        for(int i=0;i<row;i++){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][col-1]==1) dfs(grid,i,col-1);
        }

        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int i, int j){
        int row=grid.length;
        int col=grid[0].length;

        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]!=1) return;
        grid[i][j]=0;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}