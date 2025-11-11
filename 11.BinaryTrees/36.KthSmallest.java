/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int count=0;
    int result=-1;
    public int kthSmallest(Node root, int k) {
        // code here
        inorder(root,k);
        return result;
    }
    public void inorder(Node root, int k){
        if(root==null||result!=-1) return;
        inorder(root.left,k);
        count++;
        if(count==k){
            result=root.data;
            return;
        }
        inorder(root.right,k);
    }
}