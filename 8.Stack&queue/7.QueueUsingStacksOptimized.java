class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1= new Stack<>();
        s2= new Stack<>();
    }
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        // shift();
        return s1.pop();
    }
    
    public int peek() {
        // shift();
        return s1.peek();
    }
    
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }
    public void shift(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }
}