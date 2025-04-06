class Solution56 {
    public int search(int[] nums, int target) {
        int l=nums.length;
        int pivot=l-2;
        if(l==1){
            if(nums[0]==target){ 
                return 0;
            }else{
                return -1;
            }
        }
        while(pivot>=0){
            
            if(nums[pivot]>nums[pivot+1]){
                break;
            }
            pivot--;
        }
        if(pivot<0) pivot=0;
        if(nums[pivot]==target) return pivot;
        if(target>nums[l-1]){
         return binarySearch(nums,target,0,pivot);

        }else{

         return binarySearch(nums,target,pivot+1,l-1);
        }
    }
    public int binarySearch(int nums[], int target, int start, int end){
         while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
