class Solution2 {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node currNode= head;
        if(head==null){
            return new Node(x);
        }
        while(currNode.next != null){
            currNode=currNode.next;
        }
        currNode.next=new Node(x);
        return head;
    }
}