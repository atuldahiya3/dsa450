class Solution {
    public String minWindow(String s, String t) {
        int l1=s.length();
        int l2=t.length();
        if(l1<l2) return "";
        int[] hash= new int[256];
        for(int i=0;i<l2;i++){
           hash[t.charAt(i)]++;
        }
        int startIdx=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int required=l2;
        for(int right=0;right<l1;right++){
            char c=s.charAt(right);
            if(hash[c]>0){
                required--;
            }
            hash[c]--;
            while(required==0){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIdx=left;
                }
                char c2=s.charAt(left);
                hash[c2]++;
                if(hash[c2]>0){
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}