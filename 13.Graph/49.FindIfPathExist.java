class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited= new boolean[n];
        dfs(adj,source,destination,visited);
        return visited[destination];
    }
    public void dfs(List<List<Integer>> adj, int source, int destination, boolean[] visited){
        visited[source]=true;
        for(int e: adj.get(source)){
            if(!visited[e]){
                dfs(adj,e,destination,visited);
            }
        }
    }
}