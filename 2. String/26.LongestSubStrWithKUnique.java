import java.util.HashMap;

class Solution26 {
    public int longestkSubstr(String s, int k) {
        // code here
        char[] data= s.toCharArray();
        HashMap<Character,Integer> record= new HashMap<>();
        int count=-1;
        int left=0;
        for(int i=0;i<data.length;i++){
            record.put(data[i],record.getOrDefault(data[i],0)+1);
            while(record.size()>k){
                record.put(data[left],record.get(data[left])-1);
                if(record.get(data[left])<=0){
                    record.remove(data[left]);
                }
                
                left++;
            }
            if(record.size()==k){
                count=Math.max(count,i-left+1);
            }
        }
        return count;
    }
}