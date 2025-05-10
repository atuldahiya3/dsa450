import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res= new ArrayList<>();
        Deque<Integer> queue= new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            while(!queue.isEmpty() && queue.getLast()<num){
                queue.pollLast();
            }
            queue.addLast(num);
            if(i>=k && nums[i-k]==queue.getFirst()){
                queue.pollFirst();
            }
            if(i>=k-1){
                res.add(queue.getFirst());
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}