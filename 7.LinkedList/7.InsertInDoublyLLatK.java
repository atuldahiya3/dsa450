class Solution7 {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node curr=head;
        int count=0;
        Node newNode=new Node(x);
        while(curr.next!=null){
            if(count==p){
                Node temp=curr.next;
                curr.next=newNode;
                newNode.prev=curr;
                newNode.next=temp;
                temp.prev=newNode;
            }
            count++;
            curr=curr.next;
        }
        if(count==p && curr!=null){
            curr.next=newNode;
            newNode.prev=curr;
        }
        return head;
    }
}