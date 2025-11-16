class Solution {
    public int minMoves(int[] nums) {
        int maxEle=findMax(nums);
        int ans=0;
        for(int n: nums){
            ans=ans+(maxEle-n);
        }
        return ans;
    }
    public int findMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int n:nums){
            max=Math.max(max,n);
        }
        return max;
    }
}