import java.util.LinkedList;
import java.util.Queue;

public class Solution12 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;

        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0]=1;
        int[][] directions={{-1,0},{1,0},{-1,-1},{1,1},{0,-1},{0,1},{-1,1},{1,-1}};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0], col=curr[1], dist=curr[2];
            if(row==n-1 && col==n-1) return dist;
            for(int[] d:directions){
                int nr=d[0]+row, ny=d[1]+col;
                if(nr>=0 && ny>=0 && nr<n && ny<n && grid[nr][ny]==0 ){
                    q.offer(new int[]{nr,ny,dist+1});
                    grid[nr][ny]=1;
                }
            }
        }
        return -1;
    }
}