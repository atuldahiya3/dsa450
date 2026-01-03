class Solution {
    public int findDelayTime(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            int u=e[0], v=e[1], t=e[2];
            adj.get(u).add(new int[]{v,t});
        }
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src,0});
        
        int[] dist= new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0], time=curr[1];
            for(int[] neighbour: adj.get(node)){
                int newNode=neighbour[0], newTime=neighbour[1];
                if(time+newTime<dist[newNode]){
                    dist[newNode]=time+newTime;
                    pq.offer(new int[]{newNode,dist[newNode]});
                }
            }
        }
        int minTime=Integer.MIN_VALUE;
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            minTime=Math.max(minTime,dist[i]);
        }
        return minTime;
    }
}