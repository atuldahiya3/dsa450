import java.util.ArrayList;
import java.util.List;

class Solution333 {
    static List<Integer> minPartition(int N) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        int[] currency={2000,500,200,100,50,20,10,5,2,1};
        
        for(int i=0;i<currency.length;i++){
            while(N>=currency[i]){
                res.add(currency[i]);
                N-=currency[i];
            }
        }
        return res;
    }
}