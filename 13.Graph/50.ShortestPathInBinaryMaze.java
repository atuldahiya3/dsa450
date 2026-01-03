class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n=grid.length,m=grid[0].length;
         if (grid[source[0]][source[1]] == 0 ||
            grid[destination[0]][destination[1]] == 0)
            return -1;
        int[][] directions= {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{source[0],source[1],0});
        boolean[][] visited= new boolean[n][m];
        visited[source[0]][source[1]]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0], y=curr[1], dist=curr[2];
            if(x==destination[0] && y==destination[1]) return dist;
            for(int[] d : directions){
                int nx=x+d[0], ny=y+d[1];
                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && !visited[nx][ny] && grid[nx][ny]==1){
                    q.offer(new int[]{nx,ny,dist+1});
                    visited[nx][ny]=true;
                }
            }
        }
        return -1;
    }
}
