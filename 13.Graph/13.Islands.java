class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='L'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='W') return;
        grid[r][c]='W';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c+1);
        dfs(grid,r+1,c+1);
        dfs(grid,r-1,c-1);
        dfs(grid,r+1,c-1);
    }
}