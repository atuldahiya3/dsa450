import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Solution42 {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int target=n/3;
        List<Integer> res= new ArrayList<>();
        HashMap<Integer,Integer> record= new HashMap<>();

        for(int i=0;i<n;i++){
            record.put(nums[i],record.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> keys=record.keySet();
        for(int key:keys){
            if(record.get(key)>target){
                res.add(key);
            }
        }
        return res;
    }
}