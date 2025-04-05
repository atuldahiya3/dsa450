class Solution52 {

    static int findFloor(int[] arr, int x) {
        int ans=-1;
        int start=0, end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=x){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
}