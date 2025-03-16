import java.util.HashMap;

class Solution30 {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> prefixSum=new HashMap<>();
        int sum=0;
        int maxLen=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                maxLen=i+1;
            }
            if(prefixSum.containsKey(sum-k)){
                maxLen=Math.max(maxLen,i-prefixSum.get(sum-k));
            }
            if(!prefixSum.containsKey(sum-k)){
                prefixSum.put(sum, i);
            }
        }
        return maxLen;
        
    }
}
