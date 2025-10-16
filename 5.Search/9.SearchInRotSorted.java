class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[left]){
                if(nums[left]<=target && nums[mid]>=target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
                
            }else{
                if(target<=nums[right] && target>=nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}