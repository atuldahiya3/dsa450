class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<heights.length-1;i++){
            int diff=heights[i+1]-heights[i];
            if(diff<=0) continue;
            if(diff<=bricks){
                bricks-=diff;
                pq.offer(diff);
            }else if(ladders>0){
                ladders--;
                if(!pq.isEmpty() && pq.peek()>diff){
                    int biggest=pq.poll();
                    bricks+=biggest;
                    bricks-=diff;
                    pq.offer(diff);
                }
            }else{
                return i;
            }
        }
        return heights.length-1;
    }
}