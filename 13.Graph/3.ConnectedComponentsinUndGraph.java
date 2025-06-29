
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            int u=edge[0], v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited= new boolean[V];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                ArrayList<Integer> temp=new ArrayList<>();
                dfs(i, adj, temp, visited);
                res.add(temp);
            }
        }
        return res;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> temp, boolean[] visited){
        visited[node]=true;
        temp.add(node);
        for(int elem: adj.get(node)){
            if(!visited[elem]){
                dfs(elem, adj, temp, visited);
            }
        }
    }
}