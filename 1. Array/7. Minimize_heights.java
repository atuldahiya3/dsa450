import java.util.Arrays;

class Solution {
    int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int result=arr[n-1]-arr[0];
        
        for(int i=1;i<n;i++){
            int maxEle=Math.max(arr[i-1]+k,arr[n-1]-k);
            int minEle=Math.min(arr[0]+k,arr[i]-k);
            
            if(minEle<0) continue;
            result=Math.min(result, maxEle-minEle);
        }
        return result;
    }
}
