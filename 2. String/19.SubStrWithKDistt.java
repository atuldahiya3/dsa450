
class Solution19 {
    int countSubstr(String s, int k) {
       return helper(s,k)-helper(s,k-1);
    }
    int helper(String s, int k){
        int left=0, right=0, distCount=0, count=0;
        int freq[]= new int[256];
        while(right<s.length()){
            if(freq[s.charAt(right)]==0){
                distCount++;
            }
            freq[s.charAt(right)]++;
            while(distCount>k){
                freq[s.charAt(left)]--;
                if(freq[s.charAt(left)]==0){
                    distCount--;
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}