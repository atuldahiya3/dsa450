class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        int row=mat.length, col=mat[0].length;
        int[][] efforts= new int[row][col];
        for(int[] e: efforts) Arrays.fill(e,Integer.MAX_VALUE);
        efforts[0][0]=0;
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        
        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int effort=curr[0], r=curr[1], c=curr[2];
            if(r==row-1 && c==col-1) return effort;
            for(int[] d: dir){
                int nr=r+d[0], nc=c+d[1];
                
                
                if(nr>=0 && nc>=0 && nr<row && nc<col){
                    int newEffort=Math.max(effort, Math.abs(mat[r][c]-mat[nr][nc]));
                    if(newEffort<efforts[nr][nc]){
                        efforts[nr][nc]=newEffort;
                        pq.offer(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}
