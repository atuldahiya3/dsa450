class Solution {
    int maxSubarraySum(int[] arr) {
        int l=arr.length;
        int maxSum=arr[0];
        int currSum=0;
        for(int i=0;i<l;i++){
            currSum+=arr[i];
            maxSum=Math.max(currSum, maxSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
}
