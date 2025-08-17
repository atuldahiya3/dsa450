// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n=arr.length;
        int[] dp= new int[n];
        Arrays.fill(dp,1);
        int[] idx= new int[n];
        for(int i=0;i<n;i++) idx[i]=i;
        int maxLen=1;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if((dp[i]<1+dp[j]) &&(arr[i]>arr[j])){
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
