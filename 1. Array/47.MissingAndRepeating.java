import java.util.ArrayList;
import java.util.HashSet;

class Solution47 {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> res= new ArrayList<>();
        res.add(0);
        res.add(0);
        int max=Integer.MIN_VALUE;
        int sum=0;
        HashSet<Integer> count=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int initialsize=count.size();
            sum+=arr[i];
            count.add(arr[i]);
            if(initialsize==count.size()){
                res.set(0,arr[i]);
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int expectedSum=(max*(max+1))/2;
        res.set(1,expectedSum-sum);
        return res;
    }
}