import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int[] dp= new int[n];
        Arrays.fill(dp,1);
        int[] idx= new int[n];
        for(int i=0;i<n;i++) idx[i]=i;
        int maxLen=1;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] % arr[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i]=1+dp[j];
                    idx[i]=j;
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
                maxIdx=i;
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while (idx[maxIdx] != maxIdx) {
            res.add(arr[maxIdx]);
            maxIdx = idx[maxIdx];
        }
        res.add(arr[maxIdx]);
        Collections.reverse(res);
        return res;
    }
}