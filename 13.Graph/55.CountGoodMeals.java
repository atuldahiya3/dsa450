public class Solution {
    public int countPairs(int[] deliciousness) {
        int MOD=1_000_000_007;
        int[] powers= new int[22];
        powers[0]=1;
        for(int i=1;i<22;i++){
            powers[i]=2*powers[i-1];
        }
        long ans=0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int d: deliciousness){
            for(int p: powers){
                int target=p-d;
                if(map.containsKey(target)){
                    ans=(ans+map.get(target))%MOD;
                }
            }
            map.put(d,map.getOrDefault(d,0)+1);
        }
        return (int) ans;
    }
}   {
    
}
