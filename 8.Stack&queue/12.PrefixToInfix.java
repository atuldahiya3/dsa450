import java.util.Stack;

class Solution12 {
    static String preToInfix(String pre_exp) {
        Stack<String> data=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                data.push(Character.toString(ch));
            } else { // operator
                String op1 = data.pop();
                String op2 = data.pop();
                String temp = "(" + op1 + ch + op2 + ")";
                data.push(temp);
            }
        }
        
        return data.peek();
        
    }
}