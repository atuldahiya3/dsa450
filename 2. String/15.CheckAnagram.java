import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution15 {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> data= new HashMap<>();

        for(int i=0;i<s.length();i++){
            data.put(s.charAt(i),data.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            data.put(t.charAt(i),data.getOrDefault(t.charAt(i),0)-1);
        }
        for(int val:data.values()){
            if(val!=0) return false;
        }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}