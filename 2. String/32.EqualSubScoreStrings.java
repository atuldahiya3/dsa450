class Solution {
    public boolean scoreBalance(String s) {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=s.charAt(i)-'a'+1;
        }
        int beginSum=0;
        for(char c: s.toCharArray()){
            beginSum+=c-'a'+1;
            sum-=c-'a'+1;
            if(beginSum==sum) return true;
        }
        return false;
    }
}