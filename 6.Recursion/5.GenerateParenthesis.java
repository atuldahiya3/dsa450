import java.util.ArrayList;
import java.util.List;

class Solution5 {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    public void backtracking(List<String> result, String current, int open, int close, int max){
        if(close==max){
            result.add(current);
            return;
        }
        if(open<max){
            backtracking(result, current+'(', open+1, close, max);
        }
        if(close<open){
            backtracking(result, current+')', open, close+1, max);
        }
    }
}