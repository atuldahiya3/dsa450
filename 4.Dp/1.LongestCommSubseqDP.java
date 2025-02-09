import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i=0;
        int j=0;
        int l1=text1.length();
        int l2=text2.length();

        int[][] dp= new int[l1+1][l2+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return check(text1,text2,i,j,dp);

    }
    public int check(String text1, String text2, int i, int j, int[][] dp){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j]= 1+check(text1,text2,i+1,j+1,dp);
        }else{
            dp[i][j]= Math.max(check(text1,text2,i+1,j,dp),check(text1,text2,i,j+1,dp));
        }
        return dp[i][j];
    }
}