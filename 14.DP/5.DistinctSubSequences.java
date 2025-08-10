class Solution {
    public int numDistinct(String s, String t) {
        int l1=s.length();
        int l2=t.length();
        int[][] dp= new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) dp[i][0]=1;
        for(int i=1;i<=l2;i++) dp[0][i]=0;
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[l1][l2];
        // for(int[] row: dp) Arrays.fill(row,-1);
        // return helper(l1-1, l2-1, s, t, dp);
    }
    public int helper(int i, int j, String s, String t, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=helper(i-1,j-1,s,t,dp) + helper(i-1,j,s,t,dp);
        }else{
            return dp[i][j]=helper(i-1,j,s,t,dp);
        }
    }
}

