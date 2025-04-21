class Solution24{
    Node removeDuplicates(Node head){
        if(head==null || head.next==null) return head;
        // Code Here.
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                Node newNode=curr.next.next;
                curr.next=newNode;
                if(newNode!=null){
                    newNode.prev=curr;
                }
            }else{
                curr=curr.next;
            }
        }
        return head;
    }
}