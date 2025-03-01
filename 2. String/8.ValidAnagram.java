import java.util.HashMap;

class Solution2 {
    public boolean isAnagram(String s, String t) {
        int LS=s.length();
        int LT=t.length();
        if(LS!=LT){
            return false;
        }
        HashMap<Character,Integer> HS=new HashMap<>();
        HashMap<Character,Integer> HT=new HashMap<>();

        for(int i=0;i<LS;i++){
            HS.put(s.charAt(i),HS.getOrDefault(s.charAt(i),0)+1);
            HT.put(t.charAt(i),HT.getOrDefault(t.charAt(i),0)+1);
        }

        if(HS.equals(HT)){
            return true;
        }else{
            return false;
        }
    }
}