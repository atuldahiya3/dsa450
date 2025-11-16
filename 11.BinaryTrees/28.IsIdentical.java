/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    public boolean isIdentical(Node r1, Node r2) {
        // code here
        if(r1==null && r2==null) return true;
        if((r1!=null && r2==null) || (r1==null && r2!=null)) return false;
        if(r1.data!=r2.data) return false;
        return (isIdentical(r1.left, r2.left) && isIdentical(r1.right,r2.right));
    }
}