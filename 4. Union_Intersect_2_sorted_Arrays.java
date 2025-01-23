import java.util.Set;
import java.util.HashSet;

class Solution {
    public static int findUnion(int a[], int b[]) {
        int l1=a.length;
        int l2=b.length;
        int i=0;
        Set<Integer> c= new HashSet<>();
        
        while(i<l1 || i<l2){
            if(i<l1){
                c.add(a[i]);
            }
            if(i<l2){
                c.add(b[i]);
            }
            i+=1;
        }
        return c.size();
    }
}