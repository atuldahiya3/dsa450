class Solution25 {
    public void moveZeroes(int[] nums) {
        int snowballSize=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                snowballSize++;
            }else if(snowballSize>0){
                int t=nums[i];
                nums[i]=0;
                nums[i-snowballSize]=t;
            }
        }
    }
}