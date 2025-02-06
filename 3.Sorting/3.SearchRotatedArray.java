class Solution {
    public int search(int[] nums, int target) {
        int l=nums.length;
        int pivot=l-2;

        if(l==1){
            if(nums[0]==target){
                return 0;
            }
            return -1;
        }
        while(pivot>=0){
            if(nums[pivot]>nums[pivot+1]){
                break;
            }
            pivot--;
        }
        if(pivot<0){
            pivot=0;
        }
        if(target==nums[pivot]){
            return pivot;
        }
        if(target>nums[l-1]){
            return linear(nums,target,0,pivot-1);
        }else{
            return linear(nums,target,pivot+1,l-1);
        }
        
    }
    private int linear(int[] nums, int target, int start, int end){
        for(int i=start;i<=end;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}