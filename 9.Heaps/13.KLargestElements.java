class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> q= new PriorityQueue<>();
        for(int ele: arr){
            q.offer(ele);
            if(q.size()>k) q.poll();
        }
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(q.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
