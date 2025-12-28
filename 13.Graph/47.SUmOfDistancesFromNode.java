
import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] count;
    int[] ans;
    int n;
    List<Integer>[] tree;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        count=new int[n];
        ans=new int[n];
        this.n=n;
        tree= new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i]= new ArrayList<>();
        }
        for(int[] e:edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        dfs1(0,-1);
        dfs2(0,-1);
        return ans;
    }
    public void dfs1(int node, int parent){
        count[node]=1;
        for(int v: tree[node]){
            if(v==parent) continue;
            dfs1(v,node);
            count[node]+=count[v];
            ans[node]+=ans[v]+count[v];
        }
    }
    public void dfs2(int node, int parent){
        for(int v: tree[node]){
            if(v==parent) continue;
            ans[v]=ans[node]-count[v]+(n-count[v]);
            dfs2(v,node);
        }
    }
}