import java.util.*;
class Solution {
    static Node constructLL(int arr[]) {
        Node head= new Node(arr[0]);
        Node currNode=head;
        for(int i=1;i<arr.length;i++){
            currNode.next=new Node(arr[i]);
            currNode=currNode.next;
        }
        return head;
    }
}
