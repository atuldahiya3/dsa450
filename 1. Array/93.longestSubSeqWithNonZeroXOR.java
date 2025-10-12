class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xorSum=0;
        boolean allzero=true;
        for(int num: nums){
            xorSum^=num;
            if(num!=0) allzero=false;
        }
        if(allzero) return 0;
        return xorSum!=0? n : n-1 ;
    }
}