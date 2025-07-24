
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n=adj.size();
        int[] minDistances= new int[n];
        Arrays.fill(minDistances,Integer.MAX_VALUE);
        minDistances[src]=0;
        
        Queue<Integer> q= new LinkedList<>();
        q.offer(src);
        
        while(!q.isEmpty()){
            int node=q.poll();
            for(int neighbour: adj.get(node)){
                if(minDistances[neighbour]>minDistances[node]+1){
                    minDistances[neighbour]=minDistances[node]+1;
                    q.offer(neighbour);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(minDistances[i]==Integer.MAX_VALUE){
                minDistances[i]=-1;
            }
        }
        return minDistances;
    }
}
