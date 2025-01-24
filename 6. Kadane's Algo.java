//Brute force approach

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        
        int maxSum=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            int currSum=0;
            for(int j=i;j<arr.length;j++){
                currSum+=arr[j];
                maxSum=Math.max(maxSum,currSum);
            }
        }
        return maxSum;
    }
}

//Kadane's algorithm