class Solution {
    public boolean isMatch(String s, String p) {
        int l1=s.length();
        int l2=p.length();
        Boolean[][] dp= new Boolean[l1][l2];
        return helper(l1-1,l2-1,s,p,dp);
    }
    public boolean helper(int i, int j, String s, String p,Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(j<0) return false;
        if(i<0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]=helper(i-1,j-1,s,p,dp);
        }else if(p.charAt(j)=='*'){
            return dp[i][j]=(helper(i-1,j,s,p,dp) || helper(i-1,j-1,s,p,dp) || helper(i,j-1,s,p,dp));
        }else{
            return dp[i][j]=false;
        }
    }
}