// User function Template for Java

class Solution {
    public List<String> allLCS(String s1, String s2) {
        // Code here
        int n=s1.length();
        int m=s2.length();
        Set<String> res= new HashSet<>();
        int[][] dp= new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        backtrack(n, m, s1, s2, new StringBuilder(), res, dp);
        List<String> result= new ArrayList<>();
        result.addAll(res);
        Collections.sort(result);
        return result;
    }
    public void backtrack(int index1, int index2, String s1, String s2, StringBuilder current, Set<String> res, int[][] dp){
        if(index1==0 || index2==0){
            res.add(current.reverse().toString());
            current.reverse();
            return;
        }
        if(s1.charAt(index1-1)==s2.charAt(index2-1)){
            current.append(s1.charAt(index1-1));
            backtrack(index1-1, index2-1, s1, s2, current, res, dp);
            current.deleteCharAt(current.length()-1);
        }else{
            if (dp[index1 - 1][index2] >= dp[index1][index2 - 1]) {
                backtrack(index1 - 1, index2, s1, s2, current, res, dp);
            }
            if (dp[index1][index2 - 1] >= dp[index1 - 1][index2]) {
                backtrack(index1, index2 - 1, s1, s2, current, res, dp);
            }
        }
        
    }
}