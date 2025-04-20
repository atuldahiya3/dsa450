import java.util.ArrayList;

// O(n)
class Solution15 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> res= new ArrayList<>();
        while(head!=null){
            res.add(head.val);
            head=head.next;
        }
        for(int i=0;i<res.size()/2;i++){
            if(res.get(i)!=res.get(res.size()-1-i)) return false;
        }
        return true;
    }
}
//optimized

// iterative method to reverse linked list is better than recursive
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // now the slow pointer reached to the point of mid pointer
        // now we reverse the list after the mid pointer 
        // and will compare it with the first half
        ListNode secondHalf= reverse(slow);
        ListNode firstHalf= head;
        while(secondHalf!=null){
            if(firstHalf.val != secondHalf.val) return false;
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;

    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
}