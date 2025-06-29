class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int v= adj.size();
        boolean[] visited= new boolean[v];
        ArrayList<Integer> res= new ArrayList<>();
        dfsHelper(0, adj, res, visited);
        return res;
        
    }
    public void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, boolean[] visited){
        visited[node]=true;
        result.add(node);
        for (int elem : adj.get(node)) {
            if (!visited[elem]) {
                dfsHelper(elem, adj, result, visited);
            }
        }
    }
}