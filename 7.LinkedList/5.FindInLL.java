class Solution5 {
    static boolean searchKey(int n, Node head, int key) {
        Node currNode=head;
        if(n == 0) return false;
        while(currNode != null){
            if(currNode.data == key){
                return true;
            }
            currNode=currNode.next;
        }
        return false;
    }
}