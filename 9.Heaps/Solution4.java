import java.util.PriorityQueue;

public class Solution4 {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int n= arr.length;
        int count=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int num: arr){
            pq.offer(num);
        }
        for (int i = 1; i < k; i++) {
            pq.poll(); // remove k-1 smallest
        }
        return pq.peek(); // kth smallest is now on top
    }
}

