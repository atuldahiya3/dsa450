class Solution5 {
    public int maxScore(int[] cardPoints, int k) {
        int l=cardPoints.length;
        int maxSum=Integer.MIN_VALUE;
        int leftSum=0;
        int rightSum=0;

        //-> first check sum of first k elements and set it in leftSum 
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        //-> set maxSum to leftSum
        maxSum=leftSum;
        //-> set right most element of array
        int right=l-1;
        //-> iterate from k-1 to first element to slide over the array whose sum of elements is leftSum
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];     // remove last element from leftSum
            rightSum+=cardPoints[right];    // add last element of array to rightSum
            right--; // move to next element from the left
            maxSum=Math.max(maxSum, leftSum+rightSum); // update maxSum to the new Sum if it is greater
        }
        return maxSum;
    }
}