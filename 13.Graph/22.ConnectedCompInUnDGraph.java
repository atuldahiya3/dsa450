class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited= new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                ArrayList<Integer> temp= new ArrayList<>();
                dfs(i,adj,temp,visited);
                Collections.sort(temp);
                res.add(temp);
            }
        }
        // Collections.sort(res, (a, b) -> {
        //     if (a.size() != b.size()) return a.size() - b.size();
        //     for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
        //         if (!a.get(i).equals(b.get(i))) {
        //             return a.get(i) - b.get(i);
        //         }
        //     }
        //     return 0;
        // });
        return res;
        
    }
    public void dfs(int i,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> temp, boolean[] visited){
        visited[i]=true;
        temp.add(i);
        for(int e:adj.get(i)){
            if(!visited[e]){
                dfs(e,adj,temp,visited);
            }
        }
    }
}