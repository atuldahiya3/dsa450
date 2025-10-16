class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length<=2) return nums.length;
        int count=2;
        int res=Integer.MIN_VALUE;
        int sum=nums[0]+nums[1];
        for(int i=2;i<nums.length;i++){
            if(nums[i]==sum){
                sum=sum+nums[i]-nums[i-2];
                count++;
                res=Math.max(count,res);
            }else{
                count=2;
                sum=nums[i]+nums[i-1];
            }
        }
        return res==Integer.MIN_VALUE ? 2 : res;
    }
}