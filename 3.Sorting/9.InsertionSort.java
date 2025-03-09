class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        int curr=0;
        int prev=0;
        for(int i=1;i<arr.length;i++){
            curr=arr[i];
            prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
}