// User function Template for Java

class Solution {
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(s.isEmpty()) return;
        int temp=s.pop();
        reverse(s);
        insertAtBottom(s,temp);
    }
    static void insertAtBottom(Stack<Integer> s, int val){
        if(s.isEmpty()){
             s.push(val);
             return;
        }
        int top=s.pop();
        insertAtBottom(s,val);
        s.push(top);
    }
}
