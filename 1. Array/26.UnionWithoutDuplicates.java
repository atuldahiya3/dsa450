import java.util.ArrayList;
import java.util.HashSet;

class Solution26 {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashSet<Integer> set= new HashSet<>();
        for(int ele:a){
            set.add(ele);
        }
        for(int ele:b){
            set.add(ele);
        }
        
        ArrayList<Integer> res= new ArrayList<>(set);
        res.sort(null);
        return res;
    }
}
