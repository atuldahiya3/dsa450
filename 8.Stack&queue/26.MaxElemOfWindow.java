
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        int n=arr.length;
        if(n==0 || k==0) return res;
        Deque<Integer> dq= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res.add(arr[dq.peekFirst()]);
            }
        }
        return res;
    }
} 