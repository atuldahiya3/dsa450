class Solution66 {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int leftSum=0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        if(n==k){
            return leftSum;
        }
        int rightSum=0;
        int maxSum=leftSum;
        int right=n-1;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[right];
            right--;
            maxSum=Math.max(maxSum, rightSum+leftSum);
        }
        return maxSum;
    }
}