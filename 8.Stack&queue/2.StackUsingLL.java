class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode temp=new StackNode(a);
        if(top==null){
            top=temp;
        }
        temp.next=top;
        top=temp;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if(top==null){
            return -1;
        }
        StackNode temp=top;
        top=top.next;
        return temp.data;
    }
}