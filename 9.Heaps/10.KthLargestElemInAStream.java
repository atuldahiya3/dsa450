class KthLargest {

    Queue<Integer> scores;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.scores = new PriorityQueue<>();
        for (int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if(this.scores.size() < k || this.scores.peek() < val) {
            this.scores.add(val);
            if (this.scores.size() > k) {
                this.scores.remove();
            }
        }        
 


        return this.scores.peek();
    }
}