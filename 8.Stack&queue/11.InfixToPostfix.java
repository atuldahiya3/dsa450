import java.util.Stack;

class Solution11 {
    public static String infixToPostfix(String s) {
    Stack<Character> st = new Stack<>();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (Character.isLetterOrDigit(ch)) {
            result.append(ch);
        } else if (ch == '(') {
            st.push(ch);
        } else if (ch == ')') {
            while (!st.isEmpty() && st.peek() != '(') {
                result.append(st.pop());
            }
            if (!st.isEmpty() && st.peek() == '(') {
                st.pop(); // discard '('
            }
        } else { // Operator
            while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                result.append(st.pop());
            }
            st.push(ch);
        }
    }

    while (!st.isEmpty()) {
        result.append(st.pop());
    }

    return result.toString();
}
public static int priority(Character ch) {
    if (ch == '+' || ch == '-') return 1;
    if (ch == '*' || ch == '/' || ch == '%') return 2;
    if (ch == '^') return 3;
    return -1;
}
}