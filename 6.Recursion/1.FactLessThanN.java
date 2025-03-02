import java.util.ArrayList;

class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> res= new ArrayList<>();
        long fact=1;
        long i=1;
        while(fact<=n){
            res.add(fact);
            i++;
            fact*=i;
        }
        return res;
    }
}