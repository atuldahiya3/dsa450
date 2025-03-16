import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return n;
    }
    //optimized
    public int missingNumber2(int[] nums) {
        int n=nums.length;
        int expectedSum=n*(n+1)/2;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return expectedSum-sum;
    }
}