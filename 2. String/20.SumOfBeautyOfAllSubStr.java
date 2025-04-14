import java.util.HashMap;

class Solution20 {
    public int beautySum(String s) {
        int len=s.length();
        int res=0;
        for(int i=0;i<len;i++){
            HashMap<Character,Integer> record=new HashMap<>();
            for(int j=i;j<len;j++){
                record.put(s.charAt(j), record.getOrDefault(s.charAt(j),0)+1);
        
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for (Character key : record.keySet()){
                int value=record.get(key);
                if(value>max){
                    max=value;
                }
                if(value<min){
                    min=value;
                }
            }
            res+= max-min;
            }
        }
    return res;
    }
}