class Solution9 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int sum=0;
        double avg=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        avg=sum/k;
        if(avg>=threshold){
            count+=1;  
        }
        for(int i=k;i<arr.length;i++){
            sum=sum+arr[i]-arr[i-k];
            avg=sum/k;
            if(avg>=threshold){
                count++;
            }
        }
        return count;
    }
}