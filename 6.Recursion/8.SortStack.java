
/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if(!s.isEmpty()){
            int temp=s.pop();
            sort(s);
            insertAtBottom(s,temp);
        }
        return s;
    }
    public void insertAtBottom(Stack<Integer> s, int val){
        if(s.isEmpty() || s.peek()<=val){
            s.push(val);
            return;
        }
        int top=s.pop();
        insertAtBottom(s,val);
        s.push(top);
    }
}