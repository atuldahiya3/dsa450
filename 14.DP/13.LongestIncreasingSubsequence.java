class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // int[][] dp= new int[n+1][n+1];
        // for(int[] row:dp) Arrays.fill(row,0);
        int[] curr= new int[n+1];
        Arrays.fill(curr,0);
        int[] next= new int[n+1];
        Arrays.fill(next,0);
        for(int i=nums.length-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int take=0;
                if(prev==-1 || nums[i]>nums[prev]){
                    take= 1+next[i+1]; 
                }
                int notTake= next[prev+1];
               curr[prev+1]=Math.max(take,notTake);
            }
            next=curr;
        }
        return curr[0];
        // for(int[] row: dp) Arrays.fill(row,-1);
        // return helper(0,-1,nums,dp);
    }
    public int helper(int i, int prev, int[] nums, int[][] dp){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take= 1+helper(i+1,i,nums,dp); 
        }
        int notTake= helper(i+1,prev,nums,dp);
        return dp[i][prev+1]=Math.max(take,notTake);
    }
}