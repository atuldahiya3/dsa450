class Solution {
    boolean isPalindrome(String s) {
        int l=s.length();
        if(l==1){
            return true;
        }
        for(int i=0;i<l/2;i++){
            if(s.charAt(i)!=s.charAt(l-1-i)){
                return false;
            }
        }
        return true;
    }
};