class Solution6 {
    public double findMaxAverage(int[] nums, int k) {
        int l= nums.length;
        int sum=0;
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        int maxSum=sum;
        for(int i=k;i<l;i++){
            sum-=nums[i-k];
            sum+=nums[i];
            maxSum=Math.max(maxSum,sum);
        }
        return (double) maxSum/k;
    }
}