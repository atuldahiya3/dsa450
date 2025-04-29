import java.util.HashMap;
import java.util.Stack;

class Solution9 {
    public boolean isValid(String s) {
        Stack<Character> record=new Stack<>();
        HashMap<Character,Character> data=new HashMap<>();
        data.put(')','(');
        data.put(']','[');
        data.put('}','{');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' ){
                record.push(s.charAt(i));
            }else{
                if (record.isEmpty() || record.peek() != data.get(s.charAt(i))) {
                    return false;
                }
                record.pop();
            }
        }
        return record.isEmpty();
    }
}