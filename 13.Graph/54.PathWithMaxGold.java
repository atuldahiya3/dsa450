class Solution {
    int[][] dir = {
        { -1, 0 }, {1, 0}, {0, -1}, {0, 1}
    };
    public int getMaximumGold(int[][] grid) {
        int row=grid.length, col=grid[0].length;
        int res=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0 ){
                    int maxGold=dfs(i,j,grid);
                    res=Math.max(maxGold,res);
                }
            }
        }
        return res;
    }
    public int dfs(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 ) return 0;
        int validGold=grid[i][j];
        grid[i][j]=0;
        int maxGold=0;
        for(int[] d: dir){
            int newR=i+d[0], newC=j+d[1];
            int gold=dfs(newR, newC, grid);
            maxGold=Math.max(maxGold,gold);
        }
        grid[i][j]=validGold;
        return maxGold+validGold;

    }
}