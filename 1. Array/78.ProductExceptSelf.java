class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] product= new int[n];
        product[0]=nums[0];
        int[] reverseProduct= new int[n];
        reverseProduct[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            product[i]=product[i-1]*nums[i];
            reverseProduct[n-i-1]=reverseProduct[n-i]*nums[n-i-1];
        }
        nums[0]=reverseProduct[1];
        nums[n-1]=product[n-2];
        for(int i=1;i<nums.length-1;i++){
            nums[i]=product[i-1]*reverseProduct[i+1];
        }
        return nums;
    }
}