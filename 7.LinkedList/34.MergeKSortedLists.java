
import java.util.PriorityQueue;

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        if (arr == null || arr.length == 0) return null;
        PriorityQueue<Node> pq= new PriorityQueue<>((a,b)-> a.data-b.data);
        
        for(Node n: arr){
            if(n!=null){
                pq.offer(n);
            }
        }
        Node dummy= new Node(0);
        Node curr=dummy;
        while(!pq.isEmpty()){
            Node smallest=pq.poll();
            curr.next=smallest;
            curr=curr.next;
            if(smallest.next!=null){
                pq.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}