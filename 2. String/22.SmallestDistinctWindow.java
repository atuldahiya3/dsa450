import java.util.HashMap;

class Solution27 {
    public int findSubString(String str) {
        // code here
        HashMap<Character,Integer> record= new HashMap<>();
        int n=str.length();
        if (n == 0) return 0;
        for(int i=0;i<n;i++){
            record.put(str.charAt(i),record.getOrDefault(str.charAt(i),0)+1);
        }
        int window=record.size();
        int res=Integer.MAX_VALUE;;
        int start=0;
        HashMap<Character, Integer> r2= new HashMap<>();
        for(int i=0;i<n;i++){
            char c=str.charAt(i);
            r2.put(c,r2.getOrDefault(c,0)+1);
            
            while(r2.size()==window){
                res=Math.min(res,i-start+1);
                char startCh=str.charAt(start);
                r2.put(startCh, r2.get(startCh)-1);
                if(r2.get(startCh)==0){
                    r2.remove(startCh);
                }
                start++;
            }
        }
        return res;
    }
}