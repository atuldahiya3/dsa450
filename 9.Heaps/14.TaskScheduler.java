// User function Template for Java

class Solution {
    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        Map<Character, Integer> map= new HashMap<>();
        for(char c: tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);
        pq.addAll(map.values());
        int time=0;
        
        while(!pq.isEmpty()){
            ArrayList<Integer> temp= new ArrayList<>();
            int cycle=K+1;
            while(cycle-- >0 && !pq.isEmpty()){
                int curr=pq.poll();
                if(--curr>0){
                    temp.add(curr);
                }
                time++;
            }
            for(int i=0;i<temp.size();i++){
                pq.offer(temp.get(i));
            }
            if(pq.isEmpty()) break;
            
            time+=cycle+1;
        }
        return time;
    }
}
