/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i=1;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        while(i<left){
            curr=curr.next;
            i++;
        }
        ListNode leftCutPoint=curr;
        ListNode newLLHead=curr.next;
        ListNode reversedHead=reverse(newLLHead, right-left+1);
        leftCutPoint.next = reversedHead;
        return dummy.next;
        
    }
    public ListNode reverse(ListNode head, int stop){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null && stop>0){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            stop--;
        }
        head.next=curr;
        return prev;
    }
}