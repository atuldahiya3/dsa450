class Solution4 {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        boolean[] visited= new boolean[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected,i,visited);

            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, int node, boolean[] visited){
        visited[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i] && isConnected[node][i]==1){
                dfs(isConnected, i, visited);
            }
        }
    }
}