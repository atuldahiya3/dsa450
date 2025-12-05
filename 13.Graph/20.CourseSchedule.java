class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        Queue<Integer> q= new LinkedList<>();
        int[] indegree= new int[n];
        for(int[] course: prerequisites){
            adj.get(course[0]).add(course[1]);
            indegree[course[1]]++;
        }
        
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
            for(int neighbour: adj.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) q.offer(neighbour);
            }
        }
        return n==count;
    }
}