import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution8 {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c: tasks){
            freq[c-'A']++;
        }
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        for(int val:freq){
            if(val>0) maxHeap.offer(val);
        }
        int time=0;
        
        while(!maxHeap.isEmpty()){
            int i=0;
            ArrayList<Integer> temp= new ArrayList<>();
            while(i<=n){
                if(!maxHeap.isEmpty()){
                    int current=maxHeap.poll();
                    if(current>1) temp.add(current-1);
                }
                time++;
                if(maxHeap.isEmpty() && temp.size()==0){
                    break;
                }
                i++;
            }
            for(int val:temp){
                maxHeap.offer(val);
            }
        }
        return time;
    }
}