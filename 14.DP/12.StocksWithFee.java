class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp= new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    dp[i][buy]=Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
                }else{
                    dp[i][buy]=Math.max(prices[i]-fee+dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return helper(0,1,fee,prices,dp);
    }
    public int helper(int i, int buy, int fee, int[] prices, int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+helper(i+1,0,fee,prices,dp), helper(i+1,1,fee,prices,dp));
        }else{
            return dp[i][buy]=Math.max(prices[i]-fee+helper(i+1,1,fee,prices,dp), helper(i+1,0,fee,prices,dp));
        }
    }
}