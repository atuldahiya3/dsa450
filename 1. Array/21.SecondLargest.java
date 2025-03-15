public class Solution2 {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        int secondLargest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>secondLargest && arr[i]<largest){
                secondLargest=arr[i];
            }
        }
        return (secondLargest==Integer.MIN_VALUE ?-1 :secondLargest);
    }
}