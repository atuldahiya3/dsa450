class Solution6 {
    Node constructDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node currNode= head;
        for(int i=1;i<arr.length;i++){
            Node temp=currNode;
            currNode.next=new Node(arr[i]);
            currNode=currNode.next;
            currNode.prev=temp;
        }
        return head;
    }
}