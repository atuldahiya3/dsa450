class MyQueue {
    QueueNode front, rear;

    // Function to push an element into the queue.
    void push(int a) {
        // Your code here
        QueueNode newNode= new QueueNode(a);
        if(rear==null) {
            front=rear=newNode;
            return;
        }
        rear.next=newNode;
        rear=newNode;
    }

    // Function to pop front element from the queue.
    int pop() {
        if(front==null) return -1;
        int data=front.data;
        if(front==rear){
            front=rear=null;
            return data;
        }
        front=front.next;
        return data;
        // Your code here
    }
}
