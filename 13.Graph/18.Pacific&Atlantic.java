class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                bfs(i,j,heights);
            }
        }
        return res;
    }
    public void bfs(int r, int c, int[][] heights){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{r,c});
        boolean[][] visited= new boolean[heights.length][heights[0].length];
        visited[r][c]=true;
        boolean isAtlantic=false, isPacific=false;
        int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0], y=curr[1];
            if(x==0 || y==0){
                isPacific=true;
            }
            if(x==heights.length-1 || y==heights[0].length-1){
                isAtlantic=true;
            }
            if(isPacific && isAtlantic){
                res.add(Arrays.asList(r,c));
                return;
            }
            for(int[] d: directions){
                int mx=x+d[0], my=y+d[1];
                if(mx>=0 && my>=0 && mx<heights.length && my<heights[0].length && !visited[mx][my] && heights[x][y]>=heights[mx][my]){
                    visited[mx][my]=true;
                    q.offer(new int[]{mx,my});
                }
            }
        }
    }
}