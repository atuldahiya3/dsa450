import java.util.HashMap;

class Solution14 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> data= new HashMap<>();
        HashMap<Character, Character> data1= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(data.containsKey(s.charAt(i))){
                if(data.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                data.put(s.charAt(i),t.charAt(i));
            }
            if(data1.containsKey(t.charAt(i))){
                if(data1.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }else{
                data1.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}