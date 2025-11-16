/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBST(Node root) {
        // code here
        return check(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean check(Node root, int min, int max){
        if(root==null) return true;
        if(root.data<=min || root.data>=max){
            return false;
        }
        return check(root.left,min, root.data) && check(root.right,root.data,max);
    }
}