class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i,c=0;j<n;j++){
                if(nums[j]==target) ++c;
                if(2*c> (j-i+1)) count++;
            }
        }
        return count;
    }
}