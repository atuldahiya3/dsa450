
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        if (m != n - 1) return false;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited= new boolean[n];
        Queue<Integer> q= new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int temp: adj.get(curr)){
                if(!visited[temp]){
                    q.offer(temp);
                    visited[temp]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}
