class Solution11 {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low<high){
            int pivotIndex=partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
        
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        int index=low-1;
        int j=low;
        int pivot=arr[high];
        for(j=low;j<high;j++){
            if(arr[j]<=pivot){
                index++;
                arr[j]=arr[j]+arr[index]-(arr[index]=arr[j]);
            }
        }
        index++;
        arr[j]=arr[j]+arr[index]-(arr[index]=arr[j]);
        return index;
    }
}
