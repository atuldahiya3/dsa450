class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode node=head;
        while(node!=null){
            count++;
            node=node.next;
        }

        ListNode dummy=new ListNode();
        dummy.next=head;

        ListNode prevGroupEnd=dummy;
        ListNode curr=head;
        while(count>=k){
            ListNode groupStart=curr;
            ListNode next=null;
            ListNode prev=null;
            for(int i=0;i<k;i++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            prevGroupEnd.next=prev;
            groupStart.next=curr;

            prevGroupEnd=groupStart;
            count-=k;
        }
        return dummy.next;
    }
}