class Solution57 {
    public int findMin(int[] nums) {
        int l=nums.length;
        int pivot=l-2;
        while(pivot>=0){
            if(nums[pivot]>nums[pivot+1]){
                break;
            }
            pivot--;
        }
    return nums[pivot+1];
    }
}