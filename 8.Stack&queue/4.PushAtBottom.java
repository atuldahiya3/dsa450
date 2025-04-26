import java.util.Stack;

class Solution4 {
    static void reverse(Stack<Integer> s) {
        if(s==null||s.isEmpty()) return;
        int top=s.pop();
        reverse(s);
        pushAtBottom(s,top);
    }
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
}