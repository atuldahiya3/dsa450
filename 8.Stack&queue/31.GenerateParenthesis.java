
import java.util.ArrayList;

// User function Template for Java

class Solution {

    public ArrayList<String> generateParentheses(int n) {
        // code here
        ArrayList<String> res= new ArrayList<>();
        find(n/2,0,0,res,"");
        return res;
    }
    public void find(int n, int open, int close, ArrayList<String> res, String s){
        if(s.length()==2*n){
            res.add(s);
            return;
        }
        if(open<n){
            find(n,open+1,close, res, s+'(');
        }
        if(close<open){
            find(n,open,close+1,res,s+')');
        }
    }
}