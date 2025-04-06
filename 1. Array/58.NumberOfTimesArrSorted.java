import java.util.List;

class Solution58 {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int l=arr.size();
        int pivot=l-2;
        int count=0;
        while(pivot>=0){
            if(arr.get(pivot)>arr.get(pivot+1)) break;
            pivot--;
            count++;
        }
        return l-count-1;
    }
}