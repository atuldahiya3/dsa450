class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image; 
        Queue<int[]> q= new LinkedList<>();
        image[sr][sc]=color;
        q.offer(new int[]{sr,sc});
        boolean[][] visited= new boolean[image.length][image[0].length];
        visited[sr][sc]=true;
        bfs(image, q, color, visited, originalColor);
        return image;
    }
    public void bfs(int[][] image, Queue<int[]> q, int color, boolean[][] visited, int originalColor){
        int row=image.length;
        int col=image[0].length;

        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int x=curr[0], y=curr[1];
                for(int[] dir:directions){
                    int nx=x+dir[0], ny=y+dir[1];
                    if(nx>=0 && ny>=0 && nx<row && ny<col && !visited[nx][ny] && image[nx][ny] == originalColor){
                        q.offer(new int[]{nx,ny});
                        image[nx][ny]=color;
                        visited[nx][ny]=true;
                    }
                }
            }
        }
    }
}