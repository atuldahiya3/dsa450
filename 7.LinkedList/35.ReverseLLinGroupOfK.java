/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(head==null || k<=1) return head;
        Node dummy=new Node(0);
        dummy.next=head;
        Node prevGroupEnd=dummy;
        while(prevGroupEnd.next != null){
            Node kth=findKth(prevGroupEnd,k);
            if(kth==null){
                kth=getLastNode(prevGroupEnd);
            }
            
            Node groupStart= prevGroupEnd.next;
            Node nextGroupStart=kth.next;
            
            reverse(groupStart,kth);
            
            prevGroupEnd.next=kth;
            groupStart.next=nextGroupStart;
            
            prevGroupEnd=groupStart;
        }
        return dummy.next;
        
    }
    public Node findKth(Node head, int k){
        while(head!=null && k>0){
            head=head.next;
            k--;
        }
        return head;
    }
    public Node getLastNode(Node node){
        while(node.next!=null) node=node.next;
        return node;
    }
    public void reverse(Node start, Node end){
        Node prev=null;
        Node curr=start;
        Node stop=end.next;
        while(curr!=stop){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
    }
}