class Solution8 {
    public Node deleteNode(Node head, int x) {
        // code here
        if (head == null) return null;

        // If deleting the head
        if (x == 1) {
            head = head.next;
            if (head != null) head.prev = null;
            return head;
        }
        Node curr=head;
        int count=1;
        while(curr != null && count<x){
            curr=curr.next;
            count++;
        }
        if(curr!=null){
            if(curr.prev!=null){
                curr.prev.next=curr.next;
            }
            if(curr.next!=null){
                curr.next.prev=curr.prev;
            }
        }
        return head;
    }
}
