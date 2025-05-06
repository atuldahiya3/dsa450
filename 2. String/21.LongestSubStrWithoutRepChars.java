import java.util.HashMap;

class Solution21 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> record= new HashMap<>();
        int res=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(record.containsKey(s.charAt(i))){
                left=Math.max(left, record.get(s.charAt(i))+1);
            }
            record.put(s.charAt(i),i);
            res=Math.max(res,i-left+1);
        }
        return res;
    }
}