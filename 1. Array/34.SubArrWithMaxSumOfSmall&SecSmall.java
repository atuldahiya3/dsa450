class Solution34 {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int arr[]) {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            currSum=arr[i]+arr[i+1];
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}