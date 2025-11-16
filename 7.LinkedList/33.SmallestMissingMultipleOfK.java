
import java.util.HashSet;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        int maxEle=Integer.MIN_VALUE;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
                maxEle=Math.max(maxEle,nums[i]);
            }
        }
        if(maxEle==Integer.MIN_VALUE) return k;
        maxEle=maxEle/k;
        for(int i=1;i<maxEle;i++){
            if(!set.contains(k*i)){
                return k*i;
            }
        }
        return (maxEle+1)*k;
    }
}