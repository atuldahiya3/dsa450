class Solution31 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int left=expandAroundCenter(s,i,i);
            int right=expandAroundCenter(s,i,i+1);
            int len=Math.max(left,right);

            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}