class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        Queue<int[]> q= new LinkedList<>();
        int fresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int minute=bfs(grid, q, visited, fresh);
        return minute;
    }
    public int bfs(int[][] grid, Queue<int[]> q, boolean[][] visited, int fresh){
        int row=grid.length;
        int col=grid[0].length;
        int minutes=0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean rottenThisMinute=false;

            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int x=curr[0], y=curr[1];
                for(int[] dir:directions){
                    int nx=dir[0]+x, ny=dir[1]+y;
                    if(nx>=0 && ny>=0 && nx<row && ny<col && !visited[nx][ny] && grid[nx][ny]==1){
                        visited[nx][ny]=true;
                        rottenThisMinute=true;
                        grid[nx][ny]=2;
                        fresh--;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            if(rottenThisMinute) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}