class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        // int[][] dp= new int[n+1][2];
        // dp[0][0]=0;
        // dp[0][1]=0;
        int[] ahead=new int[2];
        int[] curr=new int[2];
        ahead[0]=ahead[1]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0){
                    curr[j]=Math.max(-prices[i]+ahead[1], ahead[0]);
                }else{
                    curr[j]=Math.max(prices[i]+ahead[0], ahead[1]);
                }
            }
            ahead[0]=curr[0];
            ahead[1]=curr[1];
        }
        return ahead[0];
        // for(int[] row: dp) Arrays.fill(row,-1);
        // return helper(0,1,prices,dp);
    }
    public int helper(int i, int buy, int[] prices, int[][] dp){
        if(i==prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+helper(i+1,0,prices,dp), helper(i+1,1,prices,dp));
        }else{
            return dp[i][buy]=Math.max(prices[i]+helper(i+1,1,prices,dp), helper(i+1,0,prices,dp));
        }
    }
}