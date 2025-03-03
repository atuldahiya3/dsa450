class Solution3 {
    void selectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int smallestIndex=i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[smallestIndex]){
                    smallestIndex=j;
                }
            }
            arr[i]=arr[smallestIndex]+arr[i]-(arr[smallestIndex]=arr[i]);
        }
    }
}