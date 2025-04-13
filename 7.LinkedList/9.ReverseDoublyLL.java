class Solution9 {
    public DLLNode reverseDLL(DLLNode head) {
        if(head ==null && head.next == null){
            return head;
        }
        DLLNode tail= head;
        
        while(tail.next !=null){
            tail=tail.next;
        }
        DLLNode newHead=tail;
        while(tail!=null){
            tail.next=tail.prev;
            tail.prev=tail.next;
            tail=tail.next;
        }
        return newHead;
    }
}
