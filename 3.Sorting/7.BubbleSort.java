class Solution {
    // Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[]) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            boolean isSwap=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    isSwap=true;
                    arr[j]=arr[j+1]+arr[j]-(arr[j+1]=arr[j]);
                }
            }
            if(!isSwap){
                //array is already sorted
                return;
            }
        }
    }
}
