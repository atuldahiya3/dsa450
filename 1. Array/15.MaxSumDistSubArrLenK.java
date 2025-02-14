import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        long maxSum=0;
        int start=0;
        HashMap<Integer,Integer> frequency=new HashMap<>();

        for(int end=0;end<nums.length;end++){
            sum+=nums[end];
            frequency.put(nums[end],frequency.getOrDefault(nums[end],0)+1);

            if(end-start+1==k){
                if(frequency.size()==k){
                    maxSum=Math.max(maxSum,sum);
                }
                sum-=nums[start];
                frequency.put(nums[start],frequency.get(nums[start])-1);
                if(frequency.get(nums[start])==0){
                    frequency.remove(nums[start]);
                }
                start+=1;
            }
        }
        return maxSum;
    }
}