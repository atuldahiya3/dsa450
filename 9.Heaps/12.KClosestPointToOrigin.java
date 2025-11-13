class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q= new PriorityQueue<>(
            (a,b)->((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]))
        );
        for(int[] point: points){
            q.offer(point);
            if(q.size()>k) q.poll();
        }
        int[][] res= new int[q.size()][2];
        for(int i=0;i<k;i++){
            res[i]=q.poll();
        }
        return res;
    }
}