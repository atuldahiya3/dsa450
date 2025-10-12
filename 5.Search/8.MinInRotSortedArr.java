// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int left=0, right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]<arr[right]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return arr[left];
    }
}
