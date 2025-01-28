class Solution {
    public void rotate(int[] arr) {
        int l=arr.length;
        int temp=arr[l-1];
        int prev=arr[0];
        int next=0;
        for (int i=1;i<arr.length;i++){
            next=arr[i];
            arr[i]=prev;
            prev=next;
        }
        arr[0]=temp;
        
        
    }
}