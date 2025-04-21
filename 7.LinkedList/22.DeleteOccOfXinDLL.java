class Solution22 {
    static Node deleteAllOccurOfX(Node head, int x) {
        while(head!=null && head.data==x){
            head=head.next;
            if(head!=null) head.prev=null;
        }
        
        Node curr=head;
        while(curr!=null){
            if(curr.data==x){
                Node prev=curr.prev;
                Node next=curr.next;
                
                if(prev!=null) prev.next=next;
                if(next!=null) next.prev=prev;
                
            }
            curr=curr.next;
        }
        return head;
    }
}