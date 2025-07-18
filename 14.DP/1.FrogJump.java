class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length-1;
        int[] dp= new int[height.length];
        Arrays.fill(dp, -1);
        return helper(n, height,dp);
    }
    int helper(int n, int[] height, int[] dp){
        
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left= helper(n-1,height,dp)+Math.abs(height[n]-height[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right= helper(n-2,height,dp)+Math.abs(height[n]-height[n-2]);
        }
        return dp[n]= Math.min(left,right);
    }
}