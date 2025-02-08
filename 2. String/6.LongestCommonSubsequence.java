class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i=0;
        int j=0;
        int l1=text1.length();
        int l2=text2.length();
        return check(text1,text2,i,j);

    }
    public int check(String text1, String text2, int i, int j){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+check(text1,text2,i+1,j+1);
        }else{
            return Math.max(check(text1,text2,i+1,j),check(text1,text2,i,j+1));
        }
    }
}