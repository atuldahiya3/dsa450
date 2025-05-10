import java.util.Stack;

class Solution21 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack= new Stack<>();
        for(char digit : num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        StringBuilder res= new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        res.reverse();
        while(res.length()>0 && res.charAt(0)=='0'){
            res.deleteCharAt(0);
        }
        return res.length()>0 ? res.toString() : "0";
    }
}