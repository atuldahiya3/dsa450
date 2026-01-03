class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int r=grid1.length, c=grid1[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid2[i][j]==1){
                    count+=dfs(grid1,grid2,i,j);
                }
            }
        }
        return count;
    }
    public int dfs(int[][] grid1, int[][] grid2, int i, int j){
        int r=grid1.length, c=grid1[0].length;
        int res=1;
        if(i<0 || i>=r || j<0 || j>=c || grid2[i][j]==0) return 1;
        grid2[i][j]=0;
        res&=dfs(grid1,grid2,i+1,j);
        res&=dfs(grid1,grid2,i-1,j);
        res&=dfs(grid1,grid2,i,j+1);
        res&=dfs(grid1,grid2,i,j-1);

        return res & grid1[i][j];
    }
}