import java.util.HashMap;

class Solution28 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> record= new HashMap<>();
        for(int i=0;i<t.length();i++){
            record.put(t.charAt(i),record.getOrDefault(t.charAt(i),0)+1);
        }
        int left=0;
        int count=0;
        int minLen=Integer.MAX_VALUE;
        int startIdx=0;
        HashMap<Character,Integer> data= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            data.put(ch,data.getOrDefault(ch,0)+1);
            if(record.containsKey(ch) && (record.get(ch).intValue()==data.get(ch).intValue())){
                count++;
            }
            while(count==record.size()){
                if(i-left+1<minLen){
                    minLen=i-left+1;
                    startIdx=left;
                }
                char removeChar=s.charAt(left);
                data.put(removeChar, data.get(removeChar)-1);
                if(record.containsKey(removeChar) && data.get(removeChar).intValue()<record.get(removeChar).intValue()){
                    count--;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(startIdx,startIdx+minLen);
    }
}