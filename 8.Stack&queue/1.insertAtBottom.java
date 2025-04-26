import java.util.Stack;

public class Solution1 {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()){
            st.push(x);
            return st;
        }
        int top= st.pop();
        insertAtBottom(st,x);
        st.push(top);
        return st;
    }
}