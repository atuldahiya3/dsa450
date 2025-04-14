class Solution3 {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        Node currNode= head;
        int count=1;
        if(currNode.next== null){
            return 1;
        }
        while(currNode.next != null){
            currNode=currNode.next;
            count++;
        }
        return count;
    }
}