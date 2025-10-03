import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer>[] arr= new ArrayList[len+1];
        for(int elem: map.keySet()){
            int freq=map.get(elem);
            if (arr[freq] == null) {
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(elem);
        }
        int[] res= new int[k];
        int index=0;
        for(int i=len;i>=0 && index < k;i--){
            if(arr[i]!=null){
                for (int num : arr[i]) {
                    res[index++] = num;
                    if (index == k) return res;
                }
            }
        }
        return res;
    }
}