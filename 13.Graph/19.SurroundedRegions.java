class Solution {
    public void fill(char[][] grid) {
        // Code here
        int m=grid.length, n=grid[0].length;
        boolean[][] safe= new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        int[][] directions= {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            if(grid[i][0]=='O'){
                q.offer(new int[]{i,0});
                safe[i][0]=true;
            }
            if(grid[i][n-1]=='O'){
                q.offer(new int[]{i,n-1});
                safe[i][n-1]=true;
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]=='O'){
                q.offer(new int[]{0,i});
                safe[0][i]=true;
            }
            if(grid[m-1][i]=='O'){
                q.offer(new int[]{m-1,i});
                safe[m-1][i]=true;
            }
        }
        
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int x=curr[0], y=curr[1];
            for(int[] d: directions){
                int mx=x+d[0], my=y+d[1];
                if(mx>=0 && my>=0 && mx<m && my<n && !safe[mx][my] && grid[mx][my]=='O'){
                    safe[mx][my]=true;
                    q.offer(new int[]{mx,my});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!safe[i][j]){
                    grid[i][j]='X';
                }
            }
        }
    }
}
