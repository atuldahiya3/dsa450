class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp= new int[n+1][2][k+1];
        for(int i=0;i<=n;i++){
            dp[i][0][k]=0;
            dp[i][1][k]=0;
        }
        for(int j=0;j<=1;j++){
            for(int count=0;count<k;count++){
                dp[n][j][count]=0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int count=0;count<k;count++){
                    if(buy==1){
                        dp[i][buy][count]=Math.max(-prices[i]+dp[i+1][0][count], dp[i+1][1][count]);
                    }else{
                        dp[i][buy][count]=Math.max(prices[i]+dp[i+1][1][count+1],dp[i+1][0][count]);
                    }
                }
            }
        }
        return dp[0][1][0];
    }
}