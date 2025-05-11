import java.util.HashMap;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int res=0, oddCount=0;
        for(int num:nums){
            if(num%2!=0){
                oddCount++;
            }
            res+=map.getOrDefault(oddCount-k,0);
            map.put(oddCount, map.getOrDefault(oddCount,0)+1);
        }
        return res;
    }
}