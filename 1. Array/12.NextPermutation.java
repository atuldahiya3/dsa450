class Solution3 {
    public void nextPermutation(int[] nums) {
        int l=nums.length;
        int end=l-2;
        if(l==2){
            int a=nums[0];
            nums[0]=nums[1];
            nums[1]=a;
            return;
        }
        while(end>=0 ){
            if(nums[end]<nums[end+1]){
                break;
            }
            end-=1;
        }
        if(end>=0){
            int j=l-1;
            while(nums[j]<=nums[end]){
                j-=1;
            }
            swap(nums,end,j);
        }
        reverse(nums,end+1,l-1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}