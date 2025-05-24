import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> record= new HashMap<>();
        int res=0, left=0, maxFreq=0;
        for(int i=0;i<s.length();i++){
            record.put(s.charAt(i),record.getOrDefault(s.charAt(i),0)+1);
            maxFreq=Math.max(maxFreq,record.get(s.charAt(i)));
            while((i-left+1-maxFreq)>k){
                char leftElem=s.charAt(left);
                record.put(leftElem, record.get(leftElem)-1);
                left++;
            }
            res=Math.max(res,i-left+1);
        }
        return res;
    }
}