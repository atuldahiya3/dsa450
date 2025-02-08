import java.util.Arrays;

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();

        return longestCommonSubseq(s,s2);
    }
    public int longestCommonSubseq(String s1, String s2){
        int i=0;
        int j=0;
        
        int[][] dp= new int[s1.length()+1][s2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return check(s1,s2,i,j,dp);
    }
    public int check(String s1, String s2, int i, int j, int[][] dp){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]=1+check(s1,s2,i+1,j+1,dp);
        }else{
            dp[i][j]=Math.max(check(s1,s2,i+1,j,dp),check(s1,s2,i,j+1,dp));
        }
        return dp[i][j];
    }
}