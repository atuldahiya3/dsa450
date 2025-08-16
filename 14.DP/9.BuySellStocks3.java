class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp= new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0,1,0,prices,dp);
    }
    public int helper(int i, int buy, int count, int[] prices, int[][][] dp){
        if(count>=2) return 0;
        if(i>prices.length-1) return 0;
        if(dp[i][buy][count]!=-1) return dp[i][buy][count];
        if(buy==1){
            return dp[i][buy][count]=Math.max(-prices[i]+helper(i+1,0,count,prices,dp),helper(i+1,1,count,prices,dp));
        }else{
            return dp[i][buy][count]=Math.max(prices[i]+helper(i+1,1,count+1,prices,dp), helper(i+1,0,count,prices,dp));
        }
    }
}