import java.util.ArrayList;
import java.util.Collections;

class Solution27 {
    // Function to flatten a linked list
    Node flatten(Node root) {
        Node next=root;
        ArrayList<Integer> res= new ArrayList<>();
        while(next!=null){
            Node bottom=next;
            while(bottom!=null){
                res.add(bottom.data);
                bottom=bottom.bottom;
            }
            next=next.next;
        }
        Collections.sort(res);
        Node dummy=new Node(0);
        Node temp=dummy;
        for(Integer item:res){
            Node newNode=new Node(item);
            temp.bottom=newNode;
            temp=newNode;
        }
        return dummy.bottom;
        
    }
}
