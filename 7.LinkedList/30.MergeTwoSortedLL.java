/*
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node dummy= new Node(0);
        Node temp=new Node(0);
        dummy.next=temp;
        while(head1!=null && head2!=null){
            if(head1.data>head2.data){
                Node newNode= new Node(head2.data);
                temp.next=newNode;
                temp=temp.next;
                head2=head2.next;
            }else{
                Node newNode= new Node(head1.data);
                temp.next=newNode;
                temp=temp.next;
                head1=head1.next;
            }
        }
        if(head1!=null){
            temp.next=head1;
        }
        if(head2!=null){
            temp.next=head2;
        }
        return dummy.next.next;
    }
}