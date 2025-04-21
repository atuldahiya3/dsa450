class Solution26 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length=1;
        ListNode tail=head;
        ListNode res=new ListNode(0);
        while(tail.next!=null){
            length+=1;
            tail=tail.next;
        }

        k=k%length;
        if(k==0) return head;
        ListNode newTail=head;
        for(int i=0;i<length-k-1;i++){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        tail.next=head;
        return newHead;
    }
}