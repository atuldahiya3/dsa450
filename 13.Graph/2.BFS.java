import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v=adj.size();
        ArrayList<Integer> res= new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> q= new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        
        while(!q.isEmpty()){
            int node= q.poll();
            res.add(node);
            for(int elem: adj.get(node)){
                if(!visited[elem]){
                    q.offer(elem);
                    visited[elem]=true;
                }
            }
        }
        return res;
    }
}