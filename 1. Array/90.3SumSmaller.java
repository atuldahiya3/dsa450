// User function Template for Java

import java.util.Arrays;

class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        long count=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int left=i+1, right=n-1;
            while(left<right){
               if (arr[i] + arr[left] + arr[right] < sum) {
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
