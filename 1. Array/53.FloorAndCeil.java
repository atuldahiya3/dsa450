import java.util.Arrays;

class Solution53 {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int res[]= new int[2];
        int floor=-1;
        int ceil=-1;
        int start=0, end=arr.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=x){
                floor=arr[mid];
                start=mid+1;
            }
            if(arr[mid]>=x){
                ceil=arr[mid];
                end=mid-1;
            }
        }
        
        res[0]=floor;
        res[1]=ceil;
        return res;
    }
}
