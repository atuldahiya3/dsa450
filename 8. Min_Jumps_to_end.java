class Solution {
    static int minJumps(int[] arr) {
       int l=arr.length;
       int jumps=0;
       int farthest=0;
       int currentEnd=0;
       
       if (arr[0]==0) {
           return -1;
       }
       for (int i=0; i<l; i++){
           farthest=Math.max(farthest,i+arr[i]);
           
           if(i==currentEnd){
               if(i != l-1){
                   jumps++;
                   currentEnd=farthest;
                   if (currentEnd==i){
                       return -1;
                   }
               }
           }
       }
       return jumps;
    }
}