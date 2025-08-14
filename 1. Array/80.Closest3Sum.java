class Solution {
    static int closest3Sum(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int closestSum=Integer.MAX_VALUE;
        int targetDiff=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            int j=i+1, k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                int diff=Math.abs(target-sum);
                 if (diff < targetDiff || (diff == targetDiff && sum > closestSum)) {
                    targetDiff = diff;
                    closestSum = sum;
                }
                if(sum<target){
                    j++;
                }else if(sum>target){
                    k--;
                }else{
                    return sum;
                }
            }
        }
        return closestSum;
    }
};