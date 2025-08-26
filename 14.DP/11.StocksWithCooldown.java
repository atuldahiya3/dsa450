class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp= new int[n][2][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<=1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,1,0,prices,dp);
    }
    public int helper(int i, int buy, int coolDown, int[] prices, int[][][] dp){
        if(coolDown==1) return helper(i+1,buy,0,prices,dp);
        if(i>prices.length-1) return 0;
        if(dp[i][buy][coolDown]!=-1) return dp[i][buy][coolDown];
        if(buy==1){
            return dp[i][buy][coolDown]=Math.max(-prices[i]+helper(i+1,0,0,prices,dp),helper(i+1,1,0,prices,dp));
        }else{
            return dp[i][buy][coolDown]=Math.max(prices[i]+helper(i+1,1,1,prices,dp),helper(i+1,0,0,prices,dp));
        }
    }
}