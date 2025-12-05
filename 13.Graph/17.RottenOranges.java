class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        return bfs(grid,q,visited,fresh);
    }
    public int bfs(int[][] grid, Queue<int[]> q, boolean[][] visited, int fresh){
        int row=grid.length;
        int col=grid[0].length;
        int[][] directions= {{-1,0},{1,0},{0,1},{0,-1}};
        int minutes=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean rottenThisMinute=false;
            for(int i=0;i<size;i++){
                int[] curr= q.poll();
                int x=curr[0], y=curr[1];
                for(int[] d: directions){
                    int mx= x+d[0], my=y+d[1];
                    if(mx>=0 && my>=0 && mx<row && my<col && !visited[mx][my] && grid[mx][my]==1){
                        grid[mx][my]=2;
                        visited[mx][my]=true;
                        fresh--;
                        rottenThisMinute=true;
                        q.offer(new int[]{mx,my});
                    }
                }
            }
            if(rottenThisMinute) minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}